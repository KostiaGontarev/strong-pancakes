package com.strongpancakes.quest.service

import com.strongpancakes.quest.data.profile.Achievement
import com.strongpancakes.quest.data.profile.User
import io.reactivex.Observable

/**
 * Created by dima_korolev on 17/06/2017.
 */

interface DataSource {
    companion object {
        val instance = MockupData
    }
    fun getMe(): Observable<User>
    fun getUser(id: String): Observable<User>

    fun getAchievements(): Observable<Achievement>
}
