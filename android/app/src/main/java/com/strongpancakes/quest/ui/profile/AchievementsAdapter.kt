package com.strongpancakes.quest.ui.profile

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.profile.Achievement
import kotlinx.android.synthetic.main.item_achievement.view.*

/**
 * Created by Yury Minich on 6/18/17.
 */
class AchievementsAdapter(var achievements: List<Achievement>,
                          var userAtch: Array<String>,
                          var progress: Array<String>) :
        RecyclerView.Adapter<AchievementsAdapter.ViewHolder>() {

    fun updateAchievements(achievements: List<Achievement>) {
        this.achievements = achievements
        notifyDataSetChanged()
    }

    fun updateUserAchievements(userAtch: Array<String>, progress: Array<String>) {
        this.userAtch = userAtch
        this.progress = progress
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_achievement, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTasks(achievements[position])
        if (!userAtch.isEmpty() && userAtch.contains(achievements[position].id)) {
            holder.itemView.status.setImageResource(R.drawable.ic_achieve)
        }
        if (!progress.isEmpty() && progress.contains(achievements[position].id)) {
            holder.itemView.status.setImageResource(R.drawable.ic_achieve_progress)
        }
    }

    override fun getItemCount() = achievements.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTasks(task: Achievement) {
            with(task) {
                itemView.title.text = task.name
            }
        }
    }

}