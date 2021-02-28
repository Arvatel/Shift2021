package com.arvatel.shift2021.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.arvatel.shift2021.R
import com.arvatel.shift2021.WeatherApplication
import com.arvatel.shift2021.WeatherRepository

class DetailActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private lateinit var weatherRepository: WeatherRepository

    private lateinit var cityText: TextView
    private lateinit var degreeText: TextView
    private lateinit var descriptionInput: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherRepository = (application as WeatherApplication).weatherRepository
        setContentView(R.layout.activity_detail)

        initViews()
    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val weather = weatherRepository.getWeather(id)

        if (weather != null) {
            cityText = findViewById(R.id.cityText)
            degreeText = findViewById(R.id.degreeText)
            descriptionInput = findViewById(R.id.descriptionInput)
            saveButton = findViewById(R.id.saveButton)

            cityText.text = getString(R.string.city_format, weather.city)
            degreeText.text = getString(R.string.degree_format, weather.degree)
            descriptionInput.setText(weather.description ?: getString(R.string.description_absent))

            saveButton.setOnClickListener {
                val editedPerson = weather.copy(description = descriptionInput.text.toString())
                weatherRepository.setWeather(editedPerson)
                finish()
            }
        } else {
            finish()
        }
    }
}