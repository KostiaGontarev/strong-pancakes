package com.strongpancakes.quest.ui.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.strongpancakes.quest.OfficeMeApp
import com.strongpancakes.quest.R
import com.strongpancakes.quest.ui.login.LoginActivity
import com.strongpancakes.quest.ui.main.MainActivity
import com.strongpancakes.quest.utils.RxUtil
import com.strongpancakes.quest.utils.start
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by dima_korolev on 17/06/2017.
 */
class SplashScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startTimer()
    }

    private fun startTimer() {
        Observable.just("")
                .delay(2, TimeUnit.SECONDS)
                .map { OfficeMeApp.instance.hasUser }
                .compose(RxUtil.applySchedulers())
                .subscribe { if (it) startMain() else startLogin()  }
    }

    private fun startMain() {
        start(MainActivity::class.java)
    }

    private fun startLogin() {
        start(LoginActivity::class.java)
    }
}