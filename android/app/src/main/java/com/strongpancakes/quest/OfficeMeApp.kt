package com.strongpancakes.quest

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import org.altbeacon.beacon.BeaconManager

/**
 * Created by dima_korolev on 17/06/2017.
 */

class OfficeMeApp : Application() {

    companion object Instance {
        lateinit var instance: OfficeMeApp
        private set
    }

    lateinit var auth: FirebaseAuth
    lateinit var beacon: BeaconManager

    val hasUser: Boolean
    get() = auth.currentUser!= null

    override fun onCreate() {
        super.onCreate()
        OfficeMeApp.instance = this
        initSDK()
    }

    private fun initSDK() {
        auth = FirebaseAuth.getInstance()
        beacon = BeaconManager.getInstanceForApplication(this)
    }
}
