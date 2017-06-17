package com.strongpancakes.quest.ui.main

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.strongpancakes.quest.R
import com.strongpancakes.quest.R.id.*
import com.strongpancakes.quest.ui.career.position.CareerListFragment
import com.strongpancakes.quest.ui.profile.ProfileFragment
import com.strongpancakes.quest.ui.tasks.TasksFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }

    fun startFragment(fragment: Fragment) {
        var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStackImmediate()
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.addToBackStack(null)
        } else {
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        }
        fragmentTransaction.commit()
    }

}
