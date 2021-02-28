package com.arvatel.shift2021.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.arvatel.shift2021.R
import com.arvatel.shift2021.detail.DetailActivity
import com.arvatel.shift2021.WeatherApplication
import com.arvatel.shift2021.WeatherRepository

class ListActivity : AppCompatActivity() {

    private lateinit var weatherRepository: WeatherRepository

    private lateinit var weatherList: RecyclerView

    private val adapter = WeatherAdapter {
        DetailActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherRepository = (application as WeatherApplication).weatherRepository
        setContentView(R.layout.activity_list)

        weatherList = findViewById(R.id.weatherList)
        weatherList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.weather = weatherRepository.getAllWeather()
    }
}