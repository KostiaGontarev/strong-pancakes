package com.strongpancakes.quest.ui.main.adapter

import android.content.Context
import android.preference.PreferenceManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.strongpancakes.quest.data.AddTask
import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.tasks.OfficeTask
import com.strongpancakes.quest.utils.addTask

/**
 * Created by Yury Minich on 6/17/17.
 */
class FeedDataAdapter(val context: Context, var feedData: List<FeedData>) : Adapter<RecyclerView.ViewHolder>() {
    var delegatesManager: AdapterDelegatesManager<List<FeedData>> = AdapterDelegatesManager()

    fun updateData(feedData: List<FeedData>) {
        this.feedData = feedData
        notifyDataSetChanged()
    }

    fun addData(data: FeedData) {
        val feedList = this.feedData.toMutableList()
        if (feedList.last() is AddTask) {
            feedList.add(feedList.lastIndex, data)
        } else {
            feedList.add(data)
        }
        this.feedData = feedList
        notifyDataSetChanged()
    }

    init {
        delegatesManager.addDelegate(TaskAdapterDelegate() {
            officeTask ->
            officeTask.isDone = true
            notifyDataSetChanged()
        })
        delegatesManager.addDelegate(FeedNewsAdapterDelegate())
        delegatesManager.addDelegate(AddTaskDelegate {
            PreferenceManager.getDefaultSharedPreferences(context).addTask(it)
            addData(OfficeTask.createUserTask(it))
        })
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