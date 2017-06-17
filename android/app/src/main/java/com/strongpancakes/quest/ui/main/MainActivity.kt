package com.strongpancakes.quest.ui.main

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.strongpancakes.quest.R
import com.strongpancakes.quest.R.id.*
import com.strongpancakes.quest.data.profile.User
import com.strongpancakes.quest.service.DataSource
import com.strongpancakes.quest.ui.career.position.CareerListFragment
import com.strongpancakes.quest.ui.profile.ProfileFragment
import com.strongpancakes.quest.ui.tasks.TasksFragment
import com.strongpancakes.quest.utils.RxUtil
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment(DashboardFragment())
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                actionEvents -> startFragment(DashboardFragment())
                actionTasks -> startFragment(TasksFragment())
                actionCareer -> startFragment(CareerListFragment())
                else -> {
                    false
                }
            }
            true
        }
        openProfile.setOnClickListener { startFragment(ProfileFragment()) }
        getProfileData()
    }

    override fun onStop() {
        disposable.dispose()
        super.onStop()
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

    fun getProfileData() {
        disposable = DataSource.instance.getMe()
                .compose(RxUtil.applySchedulers())
                .subscribe({
                    user ->
                    user?.let { fillUserData(it) }
                })


    }

    fun fillUserData(user: User) {
        expText.text = user.exp.toString()
        user.img?.let {
            openProfile.setImageResource(it)
        }
    }

}
