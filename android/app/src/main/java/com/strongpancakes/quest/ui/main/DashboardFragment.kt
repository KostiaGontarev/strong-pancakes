package com.strongpancakes.quest.ui.main

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.service.DataSource
import com.strongpancakes.quest.ui.main.adapter.FeedDataAdapter
import com.strongpancakes.quest.utils.RxUtil
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_dashboard.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class DashboardFragment : Fragment() {

    lateinit var disposable: Disposable
    lateinit var adapter: FeedDataAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feedView.setHasFixedSize(true)
        feedView.layoutManager = LinearLayoutManager(activity)
        adapter = FeedDataAdapter(activity, ArrayList())
        feedView.adapter = adapter
        getFeedData()
    }

    override fun onStop() {
        disposable.dispose()
        super.onStop()
    }

    fun getFeedData() {
        disposable = DataSource.instance.getFeedData()
                .compose(RxUtil.applySchedulers())
                .subscribe({ feedData -> feedData?.let { adapter.updateData(it) } })
    }

}