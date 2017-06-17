package com.strongpancakes.quest.ui.tasks

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.career.CareerPosition
import com.strongpancakes.quest.ui.career.position.CareerListAdapter
import kotlinx.android.synthetic.main.fragment_office_tasks.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class OfficeTasksFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_office_tasks, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        officeTasks.setHasFixedSize(true)
        officeTasks.layoutManager = LinearLayoutManager(activity)

        val adapter = CareerListAdapter(generateMockData()) {

        }
        officeTasks.adapter = adapter
    }

    private fun generateMockData(): List<CareerPosition> {
        val career = CareerPosition(0, "Test", "Test Descr", 0)
        var list: MutableList<CareerPosition> = ArrayList<CareerPosition>()
        list.add(career)
        return list
    }

}