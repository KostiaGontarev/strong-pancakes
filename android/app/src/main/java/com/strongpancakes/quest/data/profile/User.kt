package com.strongpancakes.quest.data.profile

/**
 * Created by dima_korolev on 17/06/2017.
 */

data class User(val email: String, val img: String? = null,
                var firstName: String, var lastName: String,
                var achieves: Array<String> = emptyArray(),
                val role: UserRole, val exp: Int = 0)