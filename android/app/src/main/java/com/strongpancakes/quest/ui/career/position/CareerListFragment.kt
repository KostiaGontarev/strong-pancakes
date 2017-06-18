package com.strongpancakes.quest.ui.career.position

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.career.CareerData
import com.strongpancakes.quest.service.DataSource
import com.strongpancakes.quest.ui.career.position.adapter.CareerListAdapter
import com.strongpancakes.quest.utils.RxUtil
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_career_list.*

/**
 * Created by Yury Minich on 6/17/17.
 */
class CareerListFragment : Fragment() {

    lateinit var disposable: Disposable;
    lateinit var adapter: CareerListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_career_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        careerList.setHasFixedSize(true)
        careerList.layoutManager = LinearLayoutManager(activity)

        adapter = CareerListAdapter(ArrayList())
        careerList.adapter = adapter
        getCareerList()
    }

    override fun onStop() {
        disposable.dispose()
        super.onStop()
    }

    private fun getCareerList() {
        disposable = DataSource.instance.getCareerPositionList()
                .compose(RxUtil.applySchedulers())
                .subscribe {
                    careerList: List<CareerData>? ->
                    careerList?.let { adapter.updateData(it) }
                }
    }
}