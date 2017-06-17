package com.strongpancakes.quest.ui.career.position

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.career.CareerPosition
import kotlinx.android.synthetic.main.fragment_career_list.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class CareerListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_career_list, container, false)
        careerList.setHasFixedSize(true)
        careerList.layoutManager = LinearLayoutManager(activity)

        val adapter = CareerListAdapter(generateMockData()) {

        }
        careerList.adapter = adapter

        return view
    }

    private fun generateMockData(): List<CareerPosition> {
        return ArrayList<CareerPosition>()
    }
}