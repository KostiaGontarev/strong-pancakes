package com.strongpancakes.quest.ui.tasks.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.tasks.OfficeTask
import kotlinx.android.synthetic.main.item_tasks.view.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class OfficeTaskAdapter(var officeTasks: List<OfficeTask>, val itemClick: (OfficeTask) -> Unit) :
        RecyclerView.Adapter<OfficeTaskAdapter.ViewHolder>() {

    fun updateData(officeTasks: List<OfficeTask>) {
        this.officeTasks = officeTasks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTasks(officeTasks[position])
    }

    override fun getItemCount() = officeTasks.size

    class ViewHolder(view: View, val itemClick: (OfficeTask) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindTasks(task: OfficeTask) {
            with(task) {
                itemView.taskTitle.text = task.title
                itemView.taskDesc.text = task.desc
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

}