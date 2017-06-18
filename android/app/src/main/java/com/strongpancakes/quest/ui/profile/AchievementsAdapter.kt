package com.strongpancakes.quest.ui.profile

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.profile.Achievement

/**
 * Created by Yury Minich on 6/18/17.
 */
class AchievementsAdapter(var achievements: List<Achievement>) :
        RecyclerView.Adapter<AchievementsAdapter.ViewHolder>() {

    fun updateAchievements(achievements: List<Achievement>) {
        this.achievements = achievements
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTasks(achievements[position])
    }

    override fun getItemCount() = achievements.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTasks(task: Achievement) {
            with(task) {
//                itemView.taskTitle.text = task.title
//                itemView.taskDesc.text = task.desc
            }
        }
    }

}