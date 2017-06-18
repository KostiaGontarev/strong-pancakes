package com.strongpancakes.quest.ui.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.profile.User
import com.strongpancakes.quest.service.DataSource
import com.strongpancakes.quest.utils.RxUtil
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_profile.*

/**
 * Created by Yury Minich on 6/18/17.
 */
class ProfileActivity : AppCompatActivity() {

    lateinit var disposable: Disposable
    lateinit var disposableAch: Disposable

    lateinit var adapter: AchievementsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        closeActivity.setOnClickListener { finish() }
        achievmentsList.setHasFixedSize(true)
        achievmentsList.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        adapter = AchievementsAdapter(ArrayList(), emptyArray(), emptyArray())

        achievmentsList.adapter = adapter
        getProfileData()
        getAchievementList()
    }

    override fun onStop() {
        disposable.dispose()
        disposableAch.dispose()
        super.onStop()
    }

    fun getProfileData() {
        disposable = DataSource.instance.getMe()
                .compose(RxUtil.applySchedulers())
                .subscribe({
                    user ->
                    user?.let { fillUserData(it) }
                })


    }

    fun getAchievementList() {
        disposableAch = DataSource.instance.getAchievements()
                .compose(RxUtil.applySchedulers())
                .subscribe({ atchivements -> atchivements?.let { adapter.updateAchievements(atchivements) } })
    }

    fun fillUserData(user: User) {
        userName.text = "${user.firstName} ${user.lastName}"
//        userEmail.text = user.email
        profileStars.text = user.exp.toString()
        level.text = user.level
        departament.text = user.depart
        birthday.text = user.birthday
        adapter.updateUserAchievements(user.achieves, user.progress)
    }


}