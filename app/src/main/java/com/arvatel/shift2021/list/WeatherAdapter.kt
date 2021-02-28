package com.arvatel.shift2021.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arvatel.shift2021.R
import com.arvatel.shift2021.Weather

class WeatherAdapter(private val onClick: (Weather) -> Unit) : RecyclerView.Adapter<PersonHolder>() {

        var weather: List<Weather> = emptyList()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
            return PersonHolder(view, onClick)
        }

        override fun onBindViewHolder(holder: PersonHolder, position: Int) {
            val oneWeather = weather[position]
            holder.bind(oneWeather)
        }

        override fun getItemCount(): Int = weather.count()
}

class PersonHolder(itemView: View, private val onClick: (Weather) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val personText: TextView = itemView.findViewById(R.id.cityText)
        private val occupationText: TextView = itemView.findViewById(R.id.descriptionText)

        fun bind(weather: Weather) {
            personText.text = itemView.context.getString(R.string.weather_city_format, weather.country, weather.city)
            occupationText.text = weather.description ?: itemView.context.getString(R.string.description_absent)
            itemView.setOnClickListener { onClick(weather) }
        }
}