package com.arvatel.shift2021

data class Weather(
    val id: Long,
    val country: String = "Russia",
    val city: String,
    val degree: Int,
    val description: String? = null
)
