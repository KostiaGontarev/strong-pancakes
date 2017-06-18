package com.strongpancakes.quest.ui.career.position.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.KoalaAdvice
import com.strongpancakes.quest.data.career.CareerData
import kotlinx.android.synthetic.main.item_koala_advice.view.*

/**
 * Created by Yury Minich on 6/18/17.
 */
class CareerKoalaAdapterDelegate : AbsListItemAdapterDelegate<KoalaAdvice, CareerData, CareerKoalaAdapterDelegate.ViewHolder>() {

    lateinit var context: Context

    override fun isForViewType(item: CareerData, items: MutableList<CareerData>, position: Int): Boolean {
        return item is KoalaAdvice
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_koala_advice, parent, false)
        return CareerKoalaAdapterDelegate.ViewHolder(view)
    }

    override fun onBindViewHolder(item: KoalaAdvice, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bindTasks(item)
        if (!item.accent.isEmpty()) {
            val accentSpan: SpannableString = SpannableString(item.text)
            accentSpan.setSpan(ForegroundColorSpan(context.resources.getColor(R.color.colorGreen)),
                    item.text.indexOf(item.accent[0]), item.text.indexOf(item.accent[item.accent.length - 1]) + 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            viewHolder.itemView.koalaAdvice.text = accentSpan
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTasks(position: KoalaAdvice) {
            with(position) {
                itemView.koalaAdvice.text = position.text
            }
        }
    }
}