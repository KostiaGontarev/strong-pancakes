package com.strongpancakes.quest.data.career

import android.graphics.Color
import com.strongpancakes.quest.R

/**
 * Created by Yury Minich on 6/17/17.
 */
enum class TaskType {
    TEST, BEACON, ARTICLE, TASK, TASK_NETWORKING, PHOTO_TASK, IDEAS, CARRIER, NOTIFICATION, MY;

    fun icon(): Int = when (this) {
        TASK_NETWORKING -> R.drawable.fa_group
        NOTIFICATION -> R.drawable.fa_flag
        else -> R.drawable.fa_trophy
    }

    fun color(): Int = when (this) {
        TASK_NETWORKING -> Color.parseColor("#009688")
        NOTIFICATION -> Color.parseColor("#e03d7f")
        else -> Color.parseColor("#f5a623")
    }

    fun title(): String = when (this) {
        TASK_NETWORKING -> "Движуха"
        NOTIFICATION -> "Новое"
        CARRIER -> "Карьера"
        else -> "Задача"
    }
}