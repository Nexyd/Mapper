package dani.kotlin.mapper.framework.listener

import dani.kotlin.domain.entities.PlaceInfo
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("tripplan/api/v1/routers/lisboa/resources?lowerLeftLatLon="
        + "38.711046,-9.160096&upperRightLatLon=38.739429,-9.137115")
    fun loadLocations(): Observable<ArrayList<PlaceInfo>>
}