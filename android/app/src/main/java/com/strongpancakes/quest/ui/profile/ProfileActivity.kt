package com.strongpancakes.quest.ui.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        getProfileData()
    }

    override fun onStop() {
        disposable.dispose()
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

    fun fillUserData(user: User) {
        userName.text = "${user.firstName} ${user.lastName}"
        userEmail.text = user.email
    }


}