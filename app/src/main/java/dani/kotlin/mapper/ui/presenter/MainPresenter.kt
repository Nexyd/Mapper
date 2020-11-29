package dani.kotlin.mapper.ui.presenter

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dani.kotlin.domain.entities.PlaceInfo
import dani.kotlin.interactors.PlaceInteractor
import dani.kotlin.interactors.LocationInteractor
import dani.kotlin.interactors.PermissionInteractor
import dani.kotlin.mapper.ui.adapter.MarkerDataAdapter
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import kotlin.random.Random

class MainPresenter @Inject constructor(
    private val permission: PermissionInteractor,
    private val place: PlaceInteractor,
    private val location: LocationInteractor
) {
    fun askMapPermission() = permission.askMapPermission()
    fun loadPlaces(): Observable<ArrayList<PlaceInfo>> = place.loadPlaces()
    private fun getUserLocation(): Observable<List<Double>> = location.getUserLocation()

    fun centerMapOnUser(map: GoogleMap) {
        val location = getUserLocation()
        location.subscribe { result ->
            val userLocation = LatLng(result[0], result[1])
            map.animateCamera(CameraUpdateFactory
                .newLatLngZoom(userLocation, 18f))
        }
    }

    fun placeMarkersIn(map: GoogleMap,
       places: List<PlaceInfo>) {

        for (index in places.indices) {
            val position = LatLng(
                places[index].y!!,
                places[index].x!!)

            val markerOptions = MarkerOptions().position(position)
                .icon(BitmapDescriptorFactory.defaultMarker(
                places[index].companyZoneId!!.toFloat()
                    / Random.nextInt(2, 6) ))

            map.addMarker(markerOptions).tag = index
        }
    }
}