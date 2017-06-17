package com.strongpancakes.quest.ui.profile

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.profile.User
import com.strongpancakes.quest.service.DataSource
import com.strongpancakes.quest.utils.RxUtil
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class ProfileFragment : Fragment() {

    lateinit var disposable: Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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