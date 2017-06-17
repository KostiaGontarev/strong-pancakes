package com.strongpancakes.quest.ui.main

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.strongpancakes.quest.R
import com.strongpancakes.quest.R.id.*
import com.strongpancakes.quest.ui.career.position.CareerListFragment
import com.strongpancakes.quest.ui.profile.ProfileFragment
import com.strongpancakes.quest.ui.tasks.TaskListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment(DashboardFragment())
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                actionEvents -> startFragment(DashboardFragment())
                actionTasks -> startFragment(TaskListFragment())
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
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
    }
}
