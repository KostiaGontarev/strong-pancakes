package com.strongpancakes.quest.data.tasks

import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.career.TaskType

/**
 * Created by Yury Minich on 6/17/17.
 */
data class OfficeTask(val id: Long, val type: TaskType,
                      val title: String,
                      val desc: String,
                      val subtitle: String,
                      val exp: Long,
                      val isDone: Boolean,
                      val attachments: Map<String, String>) : FeedData {
    companion object {
        fun createUserTask(title: String): OfficeTask {
            return OfficeTask(1, TaskType.MY, title,
                    "", "Моя задача", 1, false, HashMap<String, String>())
        }
    }
}