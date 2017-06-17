package com.strongpancakes.quest.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.tasks.OfficeTask
import kotlinx.android.synthetic.main.item_office_tasks.view.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class TaskAdapterDelegate() : AbsListItemAdapterDelegate<OfficeTask, FeedData, TaskAdapterDelegate.ViewHolder>() {

    override fun isForViewType(item: FeedData, items: MutableList<FeedData>, position: Int): Boolean {
        return item is OfficeTask
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_career_tasks, parent, false)
        return TaskAdapterDelegate.ViewHolder(view)
    }

    override fun onBindViewHolder(item: OfficeTask, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bindTasks(item)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTasks(task: OfficeTask) {
            with(task) {
                itemView.taskTitle.text = task.title
                itemView.taskDesc.text = task.desc
            }
        }
    }
}


