package dani.kotlin.data.repository

import dani.kotlin.data.listener.PlaceListener
import dani.kotlin.domain.entities.PlaceInfo
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class PlaceRepository @Inject constructor(
    private val listener: PlaceListener
) {
    fun loadPlaces(): Observable<ArrayList<PlaceInfo>> = listener.loadPlaces()
}