package com.strongpancakes.quest.utils

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.v7.widget.DialogTitle
import android.view.inputmethod.InputMethodManager
import com.strongpancakes.quest.data.tasks.OfficeTask


/**
 * Created by dima_korolev on 17/06/2017.
 */

fun Activity.start(activity: Class<out Activity>, vararg flags: Int = intArrayOf()) {
    val intent = Intent(this, activity)
    flags.forEach { intent.addFlags(it) }
    startActivity(intent)
}

fun Activity.showProgress() {
    var progressView = progressView
    if (progressView != null) {
        progressView.visibility = View.VISIBLE
    } else {
        progressView = layoutInflater.inflate(R.layout.item_progress_bar, null)
        (findViewById(android.R.id.content) as? ViewGroup)?.addView(progressView)
    }
}

fun Activity.hideProgress() {
    progressView?.visibility = View.INVISIBLE
}

fun Fragment.hideProgress() {
    activity?.progressView?.visibility = View.INVISIBLE
}

fun Fragment.showProgress() {
    activity?.showProgress()
}

val Activity.progressView: View?
get() {
    val rootContainer = (findViewById(android.R.id.content) as ViewGroup)
    if (rootContainer.childCount == 0) return null
    val topView = rootContainer.getChildAt(rootContainer.childCount - 1)
    return if (topView.id == R.id.progressViewScreen) topView else null
}

var SharedPreferences.isFirstLaunch: Boolean
get() = this.getBoolean("isFirstLaunch", true)
set(value) {
    this.edit().apply {
        putBoolean("isFirstLaunch", value)
        commit()
    }
}

fun SharedPreferences.addTask(title: String) {
    this.edit().apply {
        val prev = getString("users_tasks", "")
        putString("users_tasks", if (prev.isEmpty()) title else "$prev,$title")
        commit()
    }
}

fun SharedPreferences.getTasks(): List<OfficeTask>
        = getString("users_tasks", "").split(",").filter { !it.isEmpty() }.map { OfficeTask.createUserTask(it) }

fun View.hideKeyboard() {
    val view = (context as Activity).currentFocus
    if (view != null) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}