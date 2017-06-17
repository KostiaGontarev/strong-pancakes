package com.strongpancakes.quest

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.altbeacon.beacon.*
import org.altbeacon.beacon.powersave.BackgroundPowerSaver
import org.altbeacon.beacon.startup.BootstrapNotifier
import org.altbeacon.beacon.startup.RegionBootstrap
import java.lang.Exception


/**
 * Created by dima_korolev on 17/06/2017.
 */

class OfficeMeApp : Application(), BootstrapNotifier {

    companion object Instance {
        lateinit var instance: OfficeMeApp
        private set
    }

    lateinit var auth: FirebaseAuth
    lateinit var beacon: BeaconManager
    var backgroundPowerSaver: BackgroundPowerSaver? = null

    val hasUser: Boolean
    get() = auth.currentUser!= null

    private var regionBootstrap: RegionBootstrap? = null

    override fun onCreate() {
        super.onCreate()
        OfficeMeApp.instance = this
        initSDK()
    }

    private fun initSDK() {
        auth = FirebaseAuth.getInstance()
        beacon = BeaconManager.getInstanceForApplication(this)
//        beacon.setBackgroundMode(true)
//        beacon.beaconParsers.clear()
        beacon.beaconParsers.add(BeaconParser()
                .setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24")) // IBEACON
//        beacon.beaconParsers.add(BeaconParser()
//                .setBeaconLayout("x,s:0-1=feaa,m:2-2=20,d:3-3,d:4-5,d:6-7,d:8-11,d:12-15")) // EDDYSTONE TLM
//        beacon.beaconParsers.add(BeaconParser()
//                .setBeaconLayout("s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19")) //EDDYSTONE UID
//        beacon.removeAllRangeNotifiers()

//        val region = Region("com.strongpancakes.quest", null, null, null)
//        regionBootstrap = RegionBootstrap(this, region)

//        backgroundPowerSaver = BackgroundPowerSaver(this)
//        beacon.bind(this)
    }

    fun startMonitor(id: String) {
//        val region = Region("com.strongpancakes.quest", null, null, null)
//        regionBootstrap = RegionBootstrap(this, region)
    }

    override fun didDetermineStateForRegion(p0: Int, p1: Region?) {

    }

    override fun didEnterRegion(p0: Region?) {
//        regionBootstrap?.removeRegion(p0)
        Log.d("","WARNING!!!!")
        Log.d("","didEnterRegion")
        Log.d("",p0?.toString())
//        Toast.makeText(this, p0?.toString(), Toast.LENGTH_LONG).show()
    }

    override fun didExitRegion(p0: Region?) {
        Log.d("","WARNING!!!!")
        Log.d("","didExitRegion")
        Log.d("",p0?.toString())
    }
}
