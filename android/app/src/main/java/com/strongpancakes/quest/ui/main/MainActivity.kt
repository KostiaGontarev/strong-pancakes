package com.strongpancakes.quest.ui.main

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.strongpancakes.quest.OfficeMeApp
import com.strongpancakes.quest.R
import com.strongpancakes.quest.R.id.*
import com.strongpancakes.quest.ui.career.position.CareerListFragment
import com.strongpancakes.quest.ui.profile.ProfileFragment
import com.strongpancakes.quest.ui.tasks.TasksFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.altbeacon.beacon.BeaconConsumer
import org.altbeacon.beacon.Region
import java.lang.Exception
import org.altbeacon.beacon.Beacon



class MainActivity : AppCompatActivity(), BeaconConsumer {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPreferences(Context.MODE_PRIVATE).edit().apply {
            putBoolean("isFirst", false)
            commit()
        }
        startFragment(DashboardFragment())
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                actionEvents -> startFragment(DashboardFragment())
                actionTasks -> startFragment(TasksFragment())
                actionCareer -> startFragment(CareerListFragment())
                actionProfile -> startFragment(ProfileFragment())
                else -> {
                    false
                }
            }
            true
        }

        OfficeMeApp.instance.startMonitor("7156a32c-3399-4af2-8657-2071cd0e92df")
        OfficeMeApp.instance.beacon.bind(this)
    }

    override fun onPause() {
        super.onPause()
        OfficeMeApp.instance.beacon.setBackgroundMode(true)
    }

    override fun onResume() {
        super.onResume()
        OfficeMeApp.instance.beacon.setBackgroundMode(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        OfficeMeApp.instance.beacon.unbind(this)
    }

    fun startFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun onBeaconServiceConnect() {
        OfficeMeApp.instance.beacon.setRangeNotifier { beacons, region ->
            if (beacons.size > 0) {
                runOnUiThread {
                    val firstBeacon = beacons.iterator().next()
                    Toast.makeText(this, firstBeacon.id1.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
        try {
            OfficeMeApp.instance.beacon.startRangingBeaconsInRegion(Region("com.strongpancakes.quest", null, null, null))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
