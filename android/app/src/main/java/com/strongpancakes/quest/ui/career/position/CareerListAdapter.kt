package com.strongpancakes.quest.ui.career.position

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.career.CareerPosition
import kotlinx.android.synthetic.main.item_career_position.view.*


/**
 * Created by Yury Minich on 6/17/17.
 */
class CareerListAdapter(val careerList: List<CareerPosition>, val itemClick: (CareerPosition) -> Unit) :
        RecyclerView.Adapter<CareerListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_career_position, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCareer(careerList[position])
    }

    override fun getItemCount() = careerList.size

    class ViewHolder(view: View, val itemClick: (CareerPosition) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindCareer(position: CareerPosition) {
            with(position) {
                itemView.positionTitle.text = position.positionName
                itemView.positionDesc.text = position.positionDesc
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

}