package dani.kotlin.data.listener

import dani.kotlin.domain.entities.PlaceInfo
import io.reactivex.rxjava3.core.Observable

interface PlaceListener {
    fun loadPlaces(): Observable<ArrayList<PlaceInfo>>
}