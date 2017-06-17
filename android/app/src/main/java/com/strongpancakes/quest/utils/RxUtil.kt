package com.strongpancakes.quest.utils

import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by dima_korolev on 17/06/2017.
 */

object RxUtil {
    fun <T> applySchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) }
    }
}
