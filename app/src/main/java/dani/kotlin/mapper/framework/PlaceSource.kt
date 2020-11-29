package dani.kotlin.mapper.framework

import dani.kotlin.data.listener.PlaceListener
import dani.kotlin.domain.entities.PlaceInfo
import dani.kotlin.mapper.framework.listener.RetrofitAPI
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PlaceSource @Inject constructor(): PlaceListener {

    override fun loadPlaces(): Observable<ArrayList<PlaceInfo>> {
        val service = Retrofit.Builder()
            .baseUrl("https://apidev.meep.me/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitAPI::class.java)

        return service.loadLocations()
    }
}