package com.strongpancakes.quest.utils

import android.app.Activity
import android.content.Intent

/**
 * Created by dima_korolev on 17/06/2017.
 */

fun Activity.start(activity: Class<out Activity>) {
    startActivity(Intent(this, activity))
}