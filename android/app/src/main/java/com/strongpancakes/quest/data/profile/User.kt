package com.strongpancakes.quest.data.profile

/**
 * Created by dima_korolev on 17/06/2017.
 */

data class User(val email: String, val img: Int? = null,
                var firstName: String, var lastName: String,
                var achieves: Array<String> = emptyArray(),
                val role: UserRole, val exp: Int = 0,
                val depart: String = "D4",
                val birthday: String = "05.10.1992",
                val level: String = "Junior software developer")