package com.strongpancakes.quest.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.AddTask
import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.feed.News
import com.strongpancakes.quest.utils.hideKeyboard
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.item_add_task.view.*

/**
 * Created by dima_korolev on 18/06/2017.
 */

class AddTaskDelegate(val taskAdded: (String) -> Unit) : AbsListItemAdapterDelegate<AddTask, FeedData, AddTaskDelegate.ViewHolder>() {

    override fun isForViewType(item: FeedData, items: MutableList<FeedData>, position: Int): Boolean {
        return item is AddTask
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_add_task, parent, false)
        return AddTaskDelegate.ViewHolder(view, taskAdded)
    }

    override fun onBindViewHolder(item: AddTask, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bindTasks()
    }


    class ViewHolder(view: View, val taskAdded: (String) -> Unit) : RecyclerView.ViewHolder(view) {

        var disposable = CompositeDisposable()

        fun bindTasks() {
            disposable.dispose()
            disposable = CompositeDisposable()

            itemView.addTaskView.visibility = View.VISIBLE
            itemView.addTaskContainer.visibility = View.INVISIBLE

            disposable.add(RxView.clicks(itemView.addTaskView).subscribe {
                itemView.addTaskView.visibility = View.INVISIBLE
                itemView.addTaskContainer.visibility = View.VISIBLE
                itemView.taskText.requestFocus()
            })

            disposable.add(RxTextView.textChanges(itemView.taskText)
                    .map { it.length > 5 }
                    .subscribe(RxView.enabled(itemView.addTask)))

            disposable.add(RxView.clicks(itemView.addTask).subscribe {
                itemView.addTaskView.visibility = View.VISIBLE
                itemView.addTaskContainer.visibility = View.INVISIBLE
                taskAdded.invoke(itemView.taskText.text.toString())
                itemView.taskText.setText("")
                itemView.taskText.clearFocus()
                itemView.taskText.hideKeyboard()
            })
        }
    }
}