package com.strongpancakes.quest.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.strongpancakes.quest.OfficeMeApp
import com.strongpancakes.quest.R
import com.strongpancakes.quest.ui.main.MainActivity
import com.strongpancakes.quest.utils.start
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_create_account.*

/**
 * Created by dima_korolev on 17/06/2017.
 */


class CreateAccountActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        setupBinding()
    }


    fun setupBinding() {
        val validEmail: Observable<Boolean> = RxTextView.textChanges(emailField)
                .map { Patterns.EMAIL_ADDRESS.matcher(it).matches() }

        val validPassword: Observable<Boolean> = RxTextView.textChanges(passwordField)
                .map { it.length > 1 }

        val isSignInEnabled: Observable<Boolean> = Observable.combineLatest(validEmail, validPassword, BiFunction { e, p -> e&&p})
        isSignInEnabled.subscribe(RxView.enabled(signupBtn))

        RxView.clicks(signupBtn).subscribe { signup() }
    }

    fun signup() {
        val auth = OfficeMeApp.instance.auth

        auth.createUserWithEmailAndPassword(emailField.text.toString(), passwordField.text.toString())
                .continueWith {
                    if (it.isSuccessful) startMain()
                    else Snackbar.make(findViewById(android.R.id.content), it.exception.toString(), Snackbar.LENGTH_LONG).show()
                }
    }

    fun startMain() {
        val auth = OfficeMeApp.instance.auth
        auth.signInWithEmailAndPassword(emailField.text.toString(), passwordField.text.toString())
                .continueWith {
                    if (it.isSuccessful) start(MainActivity::class.java, Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    else {
                        Snackbar.make(findViewById(android.R.id.content), it.exception.toString(), Snackbar.LENGTH_LONG).show()
                        finish()
                    }
                }
    }
}