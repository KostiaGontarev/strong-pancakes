package com.strongpancakes.quest.service

import com.strongpancakes.quest.OfficeMeApp
import com.strongpancakes.quest.R
import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.KoalaAdvice
import com.strongpancakes.quest.data.career.CareerData
import com.strongpancakes.quest.data.career.CareerPosition
import com.strongpancakes.quest.data.career.TaskType
import com.strongpancakes.quest.data.feed.News
import com.strongpancakes.quest.data.profile.Achievement
import com.strongpancakes.quest.data.profile.User
import com.strongpancakes.quest.data.profile.UserRole
import com.strongpancakes.quest.data.tasks.OfficeTask
import io.reactivex.Observable
import java.util.ArrayList
import kotlin.collections.HashMap

/**
 * Created by dima_korolev on 17/06/2017.
 */

object MockupData : DataSource {

    private val users = arrayListOf(
            User("test@test.by", R.drawable.dima_avatar, "Dima", "Koroliov",
                    arrayOf("1", "5", "2"), UserRole.USER, 155),

            User("test@test.com", R.drawable.anton_avatar, "Anton", "Vainovich",
                    arrayOf("8", "1", "2", "3", "7", "5"), UserRole.MENTOR, 600)
    )

    private val achievements = arrayListOf(
            Achievement("1", "Испытательный срок", "", 0),
            Achievement("2", "Посетить 5 dev2dev", "", 0),
            Achievement("3", "Провести 5 dev2dev", "", 0),
            Achievement("4", "Активный перец", "", 0),
            Achievement("5", "1 год в компании", "", 0),
            Achievement("6", "Прошел испытательный срок", "", 0),
            Achievement("7", "Старожило компании", "", 0),
            Achievement("8", "Ментор", "", 0),
            Achievement("9", "Выполним 100 заданий", "", 0),
            Achievement("10", "Придумал 10 заданий", "", 0)
    )

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

        val list: MutableList<FeedData> = ArrayList()
        list.addAll(tasks)
        list.addAll(getNews())

        return Observable.just(list)
    }

    override fun getMe(): Observable<User> {
        val email = OfficeMeApp.instance.auth.currentUser?.email
        email?.let {
            return getUser(it)
        }
        return Observable.empty()
    }

    override fun getUser(email: String): Observable<User> {
        return Observable.just(users.find { it.email == email }).map { it ?: users.first() }
    }

    override fun getAchievements(): Observable<List<Achievement>> {
        return Observable.just(achievements)
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

    override fun getCareerPositionList(): Observable<List<CareerData>> = Observable.just(
            arrayListOf(
                    CareerPosition(1, "Junior software developer", "Начало карьеры 17.10.2016",
                            R.drawable.fa_child, "Старт", 155, 200),
                    KoalaAdvice("До следующей ступени осталось 45 баллов!", "45"),
                    CareerPosition(1, "Junior software developer", "Начало карьеры 17.10.2016",
                            R.drawable.fa_child, "Старт", 155, 200),
                    CareerPosition(1, "Junior software developer", "Начало карьеры 17.10.2016",
                            R.drawable.fa_child, "Старт", 155, 200),
                    CareerPosition(1, "Junior software developer", "Начало карьеры 17.10.2016",
                            R.drawable.fa_child, "Старт", 155, 200),
                    KoalaAdvice("Следующие ступени появятся по мере продвижения.")
            ))

    fun getNews(): ArrayList<FeedData> =
            arrayListOf(
                    News("Hackathon teams 2017. Registration", "yesterday at 1:20 PM • updated by Pavel Kaliukhovich • view change"),
                    News("GitLab iTechArt или как организовать работу над проектом Хакатона", "Jun 15, 2017 • updated by Iryna Mikrukova • view change"),
                    News("Hackathon teams 2017. Registration", "yesterday at 1:20 PM • updated by Pavel Kaliukhovich • view change"),
                    News("Выбор лучшего спикера iTechForum//2017", "yesterday at 1:20 PM • updated by Pavel Kaliukhovich • view change"),
                    News("Презентация жюри, критерии оценки проектов и тайминг для защиты проектов Хакатона", "Jun 13, 2017 • commented by Andrey Sotnikov")
            )

}