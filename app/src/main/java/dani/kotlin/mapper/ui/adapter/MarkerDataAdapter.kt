package dani.kotlin.mapper.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import dani.kotlin.domain.entities.PlaceInfo
import dani.kotlin.mapper.R
import dani.kotlin.mapper.databinding.MarkerInfoWindowBinding

class MarkerDataAdapter(
    private val context: Context,
    private val inflater: LayoutInflater,
    val data: List<PlaceInfo>)
    : GoogleMap.InfoWindowAdapter
{
    private lateinit var binding: MarkerInfoWindowBinding

    override fun getInfoContents(marker: Marker?): View {
        binding = MarkerInfoWindowBinding.inflate(inflater)

        val placeInfo = data[marker?.tag as Int]
        setupView(binding.name, placeInfo.name, R.string.marker_name)
        setupView(binding.licensePlate, placeInfo.licensePlate, R.string.marker_license_plate)
        setupView(binding.batteryLevel, placeInfo.batteryLevel, R.string.marker_battery_level)
        setupView(binding.helmets, placeInfo.helmets, R.string.marker_helmets)
        setupView(binding.model, placeInfo.model, R.string.marker_model)
        setupView(binding.bikes, placeInfo.bikesAvailable, R.string.marker_bikes_available)
        setupView(binding.arrival, placeInfo.scheduledArrival, R.string.marker_scheduled_arrival)

        return binding.root
    }

    private fun setupView(view: TextView, data: String?, resId: Int) {
        if (!data.isNullOrEmpty())
            view.text = context.getString(resId, data)
        else
            view.visibility = View.GONE
    }

    private fun setupView(view: TextView, data: Int?, resId: Int) {
        if (data != null)
            view.text = context.getString(resId, data)
        else
            view.visibility = View.GONE
    }

    override fun getInfoWindow(marker: Marker?): View? {
        return null
    }
}