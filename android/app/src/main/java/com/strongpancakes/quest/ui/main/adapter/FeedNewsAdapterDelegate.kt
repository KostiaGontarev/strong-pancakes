package com.strongpancakes.quest.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.feed.News
import kotlinx.android.synthetic.main.item_feed_news.view.*

/**
 * Created by Yury Minich on 6/18/17.
 */
class FeedNewsAdapterDelegate : AbsListItemAdapterDelegate<News, FeedData, FeedNewsAdapterDelegate.ViewHolder>() {

    override fun isForViewType(item: FeedData, items: MutableList<FeedData>, position: Int): Boolean {
        return item is News
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_news, parent, false)
        return FeedNewsAdapterDelegate.ViewHolder(view)
    }

    override fun onBindViewHolder(item: News, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bindTasks(item)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTasks(task: News) {
            with(task) {
                itemView.newsTitle.text = task.title
                itemView.newsDesc.text = task.subtitle
            }
        }
    }
}