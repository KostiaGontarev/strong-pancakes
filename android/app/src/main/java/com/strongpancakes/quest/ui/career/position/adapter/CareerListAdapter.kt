package com.strongpancakes.quest.ui.career.position.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.strongpancakes.quest.data.career.CareerData


/**
 * Created by Yury Minich on 6/17/17.
 */
class CareerListAdapter(var careerList: List<CareerData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var delegatesManager: AdapterDelegatesManager<List<CareerData>> = AdapterDelegatesManager()

    fun updateData(careerList: List<CareerData>) {
        this.careerList = careerList
        notifyDataSetChanged()
    }

    init {
        delegatesManager.addDelegate(CareerPositionAdapterDelegate())
        delegatesManager.addDelegate(CareerKoalaAdapterDelegate())
    }

    override fun getItemCount(): Int {
        return careerList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        delegatesManager.onBindViewHolder(careerList, position, holder!!)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(careerList, position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int, payloads: MutableList<Any>?) {
        delegatesManager.onBindViewHolder(careerList, position, holder!!, payloads!!)
    }

}
