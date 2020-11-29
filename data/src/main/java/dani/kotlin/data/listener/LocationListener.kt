package dani.kotlin.data.listener

import io.reactivex.rxjava3.core.Observable

interface LocationListener {
    fun getUserLocation(): Observable<List<Double>>
}