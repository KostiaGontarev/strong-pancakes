package com.strongpancakes.quest.service

import com.strongpancakes.quest.data.profile.Achievement
import com.strongpancakes.quest.data.profile.User
import io.reactivex.Observable

/**
 * Created by dima_korolev on 17/06/2017.
 */

object MockupData: DataSource {



    override fun getMe(): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUser(id: String): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAchievements(): Observable<Achievement> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}