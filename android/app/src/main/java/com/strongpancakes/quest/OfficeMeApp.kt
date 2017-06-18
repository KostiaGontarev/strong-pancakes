package com.strongpancakes.quest

import android.app.Application
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.strongpancakes.quest.ui.alert.KoalaAlertActivity
import io.reactivex.subjects.BehaviorSubject
import org.altbeacon.beacon.*
import org.altbeacon.beacon.powersave.BackgroundPowerSaver
import org.altbeacon.beacon.startup.RegionBootstrap
import java.lang.Exception


/**
 * Created by dima_korolev on 17/06/2017.
 */

class OfficeMeApp : Application(), BeaconConsumer {

    companion object Instance {
        lateinit var instance: OfficeMeApp
        private set
    }

    lateinit var auth: FirebaseAuth
    lateinit var beacon: BeaconManager
    var backgroundPowerSaver: BackgroundPowerSaver? = null

    val beaconSubject = BehaviorSubject.create<Beacon>()

    val hasUser: Boolean
    get() = auth.currentUser!= null

    private var regionBootstrap: RegionBootstrap? = null

    override fun onCreate() {
        super.onCreate()
        OfficeMeApp.instance = this
        initSDK()
        var used1 = false
        var used2 = false
        beaconSubject
                .filter { !used1 && it.getUUID() == "7156a32c-3399-4af2-8657-2071cd0e92df" } //55aeed94-0050-4794-856a-c438e4e4b5f4
                .subscribe {
                    used1 = true
                    KoalaAlertActivity.show("Поздравляю! Вы познакомились с нашим фичей. Это кухня :)")
                }
        beaconSubject
                .filter { !used2 && it.getUUID() == "22fe5967-8ce5-44de-9eb9-f3e69af96921" }
                .subscribe {
                    used2 = true
                    KoalaAlertActivity.show("Поздравляю! Вы познакомились с нашим фичей. Это митинг рум :)")
                }
    }

    private fun initSDK() {
        auth = FirebaseAuth.getInstance()
        beacon = BeaconManager.getInstanceForApplication(this)
//        beacon.setBackgroundMode(true)
        beacon.beaconParsers.add(BeaconParser()
                .setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24")) // IBEACON

//        val region = Region("com.strongpancakes.quest", Identifier.parse("7156a32c-3399-4af2-8657-2071cd0e92df"), null, null)
//        regionBootstrap = RegionBootstrap(this, region)

        backgroundPowerSaver = BackgroundPowerSaver(this)
        beacon.bind(this)
    }

    override fun onBeaconServiceConnect() {
        beacon.setBackgroundMode(true) //55aeed94-0050-4794-856a-c438e4e4b5fd
        OfficeMeApp.instance.beacon.setRangeNotifier { beacons, region ->
            beacons.filter { it.distance < 1.5 }
                    .forEach {
                        Log.d("BEACON", it.getUUID())
                        beaconSubject.onNext(it)
                    }
//            if (beacons.size > 0) {
//                val firstBeacon = beacons.iterator().next()
//                Observable.just(firstBeacon).observeOn(AndroidSchedulers.mainThread())
//                        .debounce(2, TimeUnit.SECONDS)
//                        .subscribe { Toast.makeText(this, "${it.distance} meters\n${it.id1}", Toast.LENGTH_SHORT).show() }
//            }
        }
        try {
            beacon.startRangingBeaconsInRegion(Region("com.strongpancakes.quest", null, null, null))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun Beacon.getUUID(): String {
        return id1.toString()
    }
}
