package com.strongpancakes.quest.ui.career.position.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.career.CareerData
import com.strongpancakes.quest.data.career.CareerPosition
import kotlinx.android.synthetic.main.item_career_position.view.*

/**
 * Created by Yury Minich on 6/18/17.
 */
class CareerPositionAdapterDelegate : AbsListItemAdapterDelegate<CareerPosition, CareerData, CareerPositionAdapterDelegate.ViewHolder>() {

    lateinit var context: Context

    override fun isForViewType(item: CareerData, items: MutableList<CareerData>, position: Int): Boolean {
        return item is CareerPosition
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_career_position, parent, false)
        return CareerPositionAdapterDelegate.ViewHolder(view)
    }

    override fun onBindViewHolder(item: CareerPosition, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bindTasks(item)
        if (item.currentExp == 0) {
            viewHolder.itemView.positionStatusText.setTextColor(context.resources.getColor(android.R.color.darker_gray))
            viewHolder.itemView.currentStar.setColorFilter(context.resources.getColor(android.R.color.darker_gray))
            viewHolder.itemView.goalStar.setColorFilter(context.resources.getColor(android.R.color.darker_gray))
            viewHolder.itemView.positionIndicator.setBackgroundColor(context.resources.getColor(android.R.color.darker_gray))
        } else {

            viewHolder.itemView.positionStatusText.setTextColor(context.resources.getColor(R.color.colorGreen))
            viewHolder.itemView.positionIndicator.setBackgroundColor(context.resources.getColor(R.color.colorGreen))
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTasks(position: CareerPosition) {
            with(position) {
                itemView.positionTitle.text = position.title
                itemView.positionDesc.text = position.subtitle
                itemView.currentBalls.text = position.currentExp.toString()
                itemView.goalBalls.text = position.newMaxExp.toString()
                itemView.positionStatusText.text = position.lvlTitle
                itemView.positionIcon.setImageResource(position.lvlIcon)
            }
        }
    }
}