package com.strongpancakes.quest.service

import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.career.TaskType
import com.strongpancakes.quest.data.profile.Achievement
import com.strongpancakes.quest.data.profile.User
import com.strongpancakes.quest.data.tasks.OfficeTask
import io.reactivex.Observable
import java.util.ArrayList
import kotlin.collections.HashMap

/**
 * Created by dima_korolev on 17/06/2017.
 */

object MockupData : DataSource {

    override fun getMe(): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(id: String): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAchievements(): Observable<Achievement> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOfficeTasks(): Observable<List<OfficeTask>> {
        var officeTask: OfficeTask = OfficeTask(1, TaskType.TEST, "Test task",
                "Test description", 10, R.drawable.ic_account_circle_white_24dp, false, HashMap<String, String>())
        var officeTask1: OfficeTask = OfficeTask(1, TaskType.TEST, "Test task1",
                "Test description1", 10, R.drawable.ic_account_circle_white_24dp, false, HashMap<String, String>())
        var officeTask2: OfficeTask = OfficeTask(1, TaskType.TEST, "Test task2",
                "Test description2", 10, R.drawable.ic_account_circle_white_24dp, false, HashMap<String, String>())
        var officeTask3: OfficeTask = OfficeTask(1, TaskType.TEST, "Test task3",
                "Test description3", 10, R.drawable.ic_account_circle_white_24dp, false, HashMap<String, String>())
        val tasks: MutableList<OfficeTask> = ArrayList();
        tasks.add(officeTask)
        tasks.add(officeTask1)
        tasks.add(officeTask2)
        tasks.add(officeTask3)

        return Observable.just(tasks)
    }

}