package dani.kotlin.mapper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import dani.kotlin.mapper.R
import dani.kotlin.mapper.dagger.component.DaggerAppComponent
import dani.kotlin.mapper.ui.adapter.MarkerDataAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private val presenter =
        DaggerAppComponent.factory()
        .create(this).getMainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.askMapPermission()
        if (::map.isInitialized)
            map.clear()

        val mapFragment = supportFragmentManager.
            findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.uiSettings.isZoomControlsEnabled = true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(
            requestCode, permissions, grantResults)

        presenter.centerMapOnUser(map)
        presenter.loadPlaces()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->

                val adapter = MarkerDataAdapter(
                    this, layoutInflater, result)

                map.setInfoWindowAdapter(adapter)
                presenter.placeMarkersIn(map, result)

            }, { error ->
                error.printStackTrace()
            })
    }
}