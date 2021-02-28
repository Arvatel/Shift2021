package com.arvatel.shift2021

class WeatherRepository {

    private val weather = mutableListOf(
        Weather(id = 0, country = "Russia", city = "Innopolis", degree = -15, description = "Sunny"),
        Weather(id = 1, country = "Russia", city = "Toomsk", degree = -32, description = "Snowy"),
        Weather(id = 2, country = "Russia", city = "Sochi", degree = 15),
        Weather(id = 3, country = "Russia", city = "St. Petersburg", degree = -5, description = "Foggy"),
        Weather(id = 4, country = "Russia", city = "Moscow", degree = -17),
        Weather(id = 5, country = "Russia", city = "Novosibirsk", degree = -25, description = "Sunny"),
        Weather(id = 6, country = "Russia", city = "Barnaul", degree = -21, description = "Cloudy"),
    )

    fun getAllWeather() : List<Weather> = weather

    fun getWeather(id: Long) : Weather? = weather.firstOrNull { it.id == id }

    fun setWeather(oneWeather: Weather) {
        val editedWeatherIndex = weather.indexOfFirst { it.id == oneWeather.id}
        if (editedWeatherIndex >= 0) {
            weather[editedWeatherIndex] = oneWeather
        }
    }
}