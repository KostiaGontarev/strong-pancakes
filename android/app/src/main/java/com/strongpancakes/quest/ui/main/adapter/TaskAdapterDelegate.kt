package com.strongpancakes.quest.ui.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.tasks.OfficeTask
import kotlinx.android.synthetic.main.item_tasks.view.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class TaskAdapterDelegate(val itemClick: (OfficeTask) -> Unit) : AbsListItemAdapterDelegate<OfficeTask, FeedData, TaskAdapterDelegate.ViewHolder>() {

    lateinit var context: Context

    override fun isForViewType(item: FeedData, items: MutableList<FeedData>, position: Int): Boolean {
        return item is OfficeTask
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false)
        return TaskAdapterDelegate.ViewHolder(view)
    }

    override fun onBindViewHolder(item: OfficeTask, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bindTasks(item, itemClick)
        if (item.isDone) {
            viewHolder.itemView.card_view.setBackgroundColor(context.resources.getColor(R.color.color))
            viewHolder.itemView.taskTypeColor.setBackgroundColor(context.resources.getColor(android.R.color.darker_gray))
            viewHolder.itemView.star.setColorFilter(context.resources.getColor(android.R.color.darker_gray))
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTasks(task: OfficeTask, listener: (OfficeTask) -> Unit) {
            with(task) {
                itemView.taskTitle.text = task.title
                itemView.taskDesc.text = task.subtitle
                itemView.taskExp.text = task.exp.toString()
                itemView.taskTypeColor.setBackgroundColor(task.type.color())
                itemView.taskTypeTitle.text = task.type.title()
                itemView.taskIcon.setImageResource(task.type.icon())
                itemView.setOnLongClickListener { v ->
                    listener(task)
                    true
                }
            }
        }
    }
}


