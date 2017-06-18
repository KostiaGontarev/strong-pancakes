package com.strongpancakes.quest.data.career

import com.strongpancakes.quest.data.FeedData

/**
 * Created by Yury Minich on 6/17/17.
 */
data class CareerPosition(val id: Long, val title: String, val subtitle: String,
                          val lvlIcon: Int, val lvlTitle: String,
                          val currentExp: Int, val newMaxExp: Int): CareerData