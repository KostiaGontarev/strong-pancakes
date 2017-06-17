package com.strongpancakes.quest

import android.app.Application
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by dima_korolev on 17/06/2017.
 */

class OfficeMeApp : Application() {

    companion object Instance {
        lateinit var instance: OfficeMeApp
        private set
    }

    lateinit var mAuth: FirebaseAuth

    val hasUser: Boolean
    get() = mAuth.currentUser!= null

    override fun onCreate() {
        super.onCreate()
        OfficeMeApp.instance = this
        initSDK()
    }

    private fun initSDK() {
        mAuth = FirebaseAuth.getInstance()
    }
}
