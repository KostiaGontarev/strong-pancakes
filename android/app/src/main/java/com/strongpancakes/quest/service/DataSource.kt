package com.strongpancakes.quest.service

import com.strongpancakes.quest.data.FeedData
import com.strongpancakes.quest.data.career.CareerPosition
import com.strongpancakes.quest.data.profile.Achievement
import com.strongpancakes.quest.data.profile.User
import com.strongpancakes.quest.data.tasks.OfficeTask
import io.reactivex.Observable

/**
 * Created by dima_korolev on 17/06/2017.
 */

interface DataSource {
    companion object {
        val instance = MockupData
    }

    fun getMe(): Observable<User>
    fun getUser(email: String): Observable<User>

    fun getAchievements(): Observable<List<Achievement>>
    fun getOfficeTasks(): Observable<List<OfficeTask>>
    fun getCareerPositionList(): Observable<List<CareerPosition>>
    fun getCareerTasks(): Observable<List<OfficeTask>>
    fun getFeedData(): Observable<List<FeedData>>
}
