package dani.kotlin.data.repository

import dani.kotlin.data.listener.LocationListener
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class LocationRepository @Inject constructor(private val listener: LocationListener) {
    fun getUserLocation(): Observable<List<Double>> = listener.getUserLocation()
}