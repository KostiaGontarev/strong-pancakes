package com.strongpancakes.quest.ui.tasks

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.tasks.OfficeTask
import com.strongpancakes.quest.service.DataSource
import com.strongpancakes.quest.ui.tasks.adapters.OfficeTaskAdapter
import com.strongpancakes.quest.utils.RxUtil
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_office_tasks.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class OfficeTasksFragment : Fragment() {

    lateinit var disposable: Disposable;
    lateinit var adapter: OfficeTaskAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_office_tasks, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        officeTasks.setHasFixedSize(true)
        officeTasks.layoutManager = LinearLayoutManager(activity)

        adapter = OfficeTaskAdapter(ArrayList()) {

        }
        officeTasks.adapter = adapter
        getOfficeTasks()
    }

    override fun onStop() {
        disposable.dispose()
        super.onStop()
    }

    private fun getOfficeTasks() {
        disposable = DataSource.instance.getOfficeTasks()
                .compose(RxUtil.applySchedulers())
                .subscribe {
                    tasks: List<OfficeTask>? ->
                    tasks?.let { adapter.updateData(it) }
                }
    }

}