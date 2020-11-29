package dani.kotlin.interactors

import dani.kotlin.data.repository.PlaceRepository
import dani.kotlin.domain.entities.PlaceInfo
import javax.inject.Inject

class PlaceInteractor @Inject constructor(private val repository: PlaceRepository) {

    fun loadPlaces() = repository.loadPlaces()
}