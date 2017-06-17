package com.strongpancakes.quest.ui.login

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v13.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.strongpancakes.quest.OfficeMeApp
import com.strongpancakes.quest.R
import com.strongpancakes.quest.ui.main.MainActivity
import com.strongpancakes.quest.utils.hideProgress
import com.strongpancakes.quest.utils.showProgress
import com.strongpancakes.quest.utils.start
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_login.*


/**
 * Created by dima_korolev on 17/06/2017.
 */

class LoginActivity : AppCompatActivity() {

    val MY_PERMISSIONS_REQUEST_READ_CONTACTS = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupBinding()
        requestPermission()
    }

    fun setupBinding() {
        val validEmail: Observable<Boolean> = RxTextView.textChanges(emailField)
                .map { Patterns.EMAIL_ADDRESS.matcher(it).matches() }

        val validPassword: Observable<Boolean> = RxTextView.textChanges(passwordField)
                .map { it.length > 1 }

        val isSignInEnabled: Observable<Boolean> = Observable.combineLatest(validEmail, validPassword, BiFunction {e, p -> e&&p})
        isSignInEnabled.subscribe(RxView.enabled(loginBtn))

        RxView.clicks(loginBtn).subscribe { login() }
        RxView.clicks(createAccount).subscribe { startSignup() }
    }

    fun login() {
        val auth = OfficeMeApp.instance.auth
        showProgress()
        auth.signInWithEmailAndPassword(emailField.text.toString(), passwordField.text.toString())
                .continueWith {
                    hideProgress()
                    if (it.isSuccessful) startMain()
                    else Snackbar.make(findViewById(android.R.id.content), it.exception?.message ?: "Error", Snackbar.LENGTH_LONG).show()
                }
    }

    fun startMain() {
        start(MainActivity::class.java, Intent.FLAG_ACTIVITY_CLEAR_TOP)
        finish()
    }

    fun startSignup() {
        start(CreateAccountActivity::class.java)
    }

    fun requestPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS)
        }
    }
}