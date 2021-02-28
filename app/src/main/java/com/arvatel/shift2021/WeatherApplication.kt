package com.arvatel.shift2021

import android.app.Application

class WeatherApplication : Application() {

    lateinit var weatherRepository: WeatherRepository

    override fun onCreate() {
        super.onCreate()
        weatherRepository = WeatherRepository()
    }
}