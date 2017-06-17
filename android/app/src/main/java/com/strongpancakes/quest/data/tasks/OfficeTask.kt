package com.strongpancakes.quest.data.tasks

import com.strongpancakes.quest.data.career.TaskType

/**
 * Created by Yury Minich on 6/17/17.
 */
data class OfficeTask(val id: Long, val type: TaskType, val title: String, val desc: String,
                      val exp: Long, val icon: String, val isDone: Boolean, val attachments: Map<String, String>)