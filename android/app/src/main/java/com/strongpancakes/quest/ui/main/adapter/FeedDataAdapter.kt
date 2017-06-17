package com.strongpancakes.quest.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.strongpancakes.quest.data.FeedData

/**
 * Created by Yury Minich on 6/17/17.
 */
class FeedDataAdapter(var feedData: List<FeedData>) : Adapter<RecyclerView.ViewHolder>() {
    var delegatesManager: AdapterDelegatesManager<List<FeedData>> = AdapterDelegatesManager()

    fun updateData(feedData: List<FeedData>){
        this.feedData = feedData;
        notifyDataSetChanged()
    }

    init {
        delegatesManager.addDelegate(TaskAdapterDelegate())
    }

    override fun getItemCount(): Int {
        return feedData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        delegatesManager.onBindViewHolder(feedData, position, holder!!)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(feedData, position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int, payloads: MutableList<Any>?) {
        delegatesManager.onBindViewHolder(feedData, position, holder!!, payloads!!)
    }

}