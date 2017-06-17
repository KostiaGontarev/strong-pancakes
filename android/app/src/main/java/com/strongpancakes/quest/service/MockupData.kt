package com.strongpancakes.quest.service

import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.career.CareerPosition
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

    override fun getFeedData(): Observable<List<FeedData>> {
        var officeTask: OfficeTask = OfficeTask(1, TaskType.CARRIER, "Прочитать книгу “Разработка требований к программному обеспечению",
                "Test description", "Выполнить до 18.06.2017", 2, false, HashMap<String, String>())
        var officeTask1: OfficeTask = OfficeTask(1, TaskType.CARRIER, "Подготовить выступление на Dev2Dev",
                "Test description1", "Выполнить до 28.06.2017", 5, false, HashMap<String, String>())
        var officeTask2: OfficeTask = OfficeTask(1, TaskType.NOTIFICATION, "Павел Прохоров выполнил задание",
                "Test description2", "Выполнено 10.06.2017", 3, false, HashMap<String, String>())
        var officeTask3: OfficeTask = OfficeTask(1, TaskType.TASK_NETWORKING, "Играем в кикер",
                "Test description3", "Начало 10.06.2017 в 13.30, 9 этаж", 1, false, HashMap<String, String>())
        val tasks: MutableList<OfficeTask> = ArrayList()
        tasks.add(officeTask)
        tasks.add(officeTask1)
        tasks.add(officeTask2)
        tasks.add(officeTask3)

        return Observable.just(tasks)
    }

    override fun getMe(): Observable<User> {
        return Observable.empty()
    }

    override fun getUser(id: String): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAchievements(): Observable<Achievement> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOfficeTasks(): Observable<List<OfficeTask>> {
        var officeTask: OfficeTask = OfficeTask(1, TaskType.CARRIER, "Прочитать книгу “Разработка требований к программному обеспечению",
                "Test description", "Выполнить до 18.06.2017", 2, false, HashMap<String, String>())
        var officeTask1: OfficeTask = OfficeTask(1, TaskType.CARRIER, "Подготовить выступление на Dev2Dev",
                "Test description1", "Выполнить до 28.06.2017", 5, false, HashMap<String, String>())
        var officeTask2: OfficeTask = OfficeTask(1, TaskType.NOTIFICATION, "Павел Прохоров выполнил задание",
                "Test description2", "Выполнено 10.06.2017", 3, false, HashMap<String, String>())
        var officeTask3: OfficeTask = OfficeTask(1, TaskType.TASK_NETWORKING, "Играем в кикер",
                "Test description3", "Начало 10.06.2017 в 13.30, 9 этаж", 1, false, HashMap<String, String>())
        val tasks: MutableList<OfficeTask> = ArrayList()
        tasks.add(officeTask)
        tasks.add(officeTask1)
        tasks.add(officeTask2)
        tasks.add(officeTask3)

        return Observable.just(tasks)
    }

    override fun getCareerTasks(): Observable<List<OfficeTask>> {
        var officeTask: OfficeTask = OfficeTask(1, TaskType.CARRIER, "Прочитать книгу “Разработка требований к программному обеспечению",
                "Test description", "Выполнить до 18.06.2017", 2, false, HashMap<String, String>())
        var officeTask1: OfficeTask = OfficeTask(1, TaskType.CARRIER, "Подготовить выступление на Dev2Dev",
                "Test description1", "Выполнить до 28.06.2017", 5, false, HashMap<String, String>())
        var officeTask2: OfficeTask = OfficeTask(1, TaskType.NOTIFICATION, "Павел Прохоров выполнил задание",
                "Test description2", "Выполнено 10.06.2017", 3, false, HashMap<String, String>())
        var officeTask3: OfficeTask = OfficeTask(1, TaskType.TASK_NETWORKING, "Играем в кикер",
                "Test description3", "Начало 10.06.2017 в 13.30, 9 этаж", 1, false, HashMap<String, String>())
        val tasks: MutableList<OfficeTask> = ArrayList();
        tasks.add(officeTask)
        tasks.add(officeTask1)
        tasks.add(officeTask2)
        tasks.add(officeTask3)

        return Observable.just(tasks)
    }

    override fun getCareerPositionList(): Observable<List<CareerPosition>> {
        val career = CareerPosition(0, "Test", "Test Descr", 0)
        val career1 = CareerPosition(0, "Test1", "Test Descr1", 0)
        var list: MutableList<CareerPosition> = ArrayList<CareerPosition>()
        list.add(career)
        list.add(career1)
        return Observable.just(list)
    }

}