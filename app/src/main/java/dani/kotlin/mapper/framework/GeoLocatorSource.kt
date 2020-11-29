package dani.kotlin.mapper.framework

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dani.kotlin.data.listener.LocationListener
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import javax.inject.Inject

class GeoLocatorSource @Inject constructor(
    private val context: Context
) : LocationListener {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun getUserLocation(): Observable<List<Double>> {
        fusedLocationClient = LocationServices
            .getFusedLocationProviderClient(context)

        val userLocation = arrayListOf<Double>()
        var locationObserver = Observable.create(
            ObservableOnSubscribe<List<Double>> { emitter ->
            emitter.onNext(userLocation)
        })

        if (ActivityCompat.checkSelfPermission(context,
            android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED)
        {
            locationObserver = Observable.create { emitter ->
                try {
                    fusedLocationClient.lastLocation.addOnSuccessListener(
                        context as Activity) { location ->

                        if (location != null) {
                            userLocation.add(location.latitude)
                            userLocation.add(location.longitude)

                            emitter.onNext(userLocation)
                        }
                    }

                } catch (ex: Exception) {
                    ex.printStackTrace()
                    emitter.onError(ex)
                }
            }
        }

        return locationObserver
    }
}