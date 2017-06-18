package com.strongpancakes.quest.ui.career.position.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.KoalaAdvice
import com.strongpancakes.quest.data.career.CareerData

/**
 * Created by Yury Minich on 6/18/17.
 */
class CareerKoalaAdapterDelegate : AbsListItemAdapterDelegate<KoalaAdvice, CareerData, CareerKoalaAdapterDelegate.ViewHolder>() {

    override fun isForViewType(item: CareerData, items: MutableList<CareerData>, position: Int): Boolean {
        return item is KoalaAdvice
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_koala_advice, parent, false)
        return CareerKoalaAdapterDelegate.ViewHolder(view)
    }

    override fun onBindViewHolder(item: KoalaAdvice, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bindTasks(item)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTasks(position: KoalaAdvice) {
            with(position) {
                //                itemView.newsTitle.text = position.title
//                itemView.newsDesc.text = position.subtitle
            }
        }
    }
}