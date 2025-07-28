package com.example.sunnyweather.android.ui.weather

import androidx.lifecycle.*
import com.example.sunnyweather.android.logic.model.Location
import com.example.sunnyweather.android.logic.Repository
import androidx.lifecycle.switchMap

class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = locationLiveData.switchMap { location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }

}