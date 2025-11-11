package com.example.fliteapp_v1

data class FlightData(
    val airlineName: String,
    val airlineLogo: Int,
    val departureCode: String,
    val departureTime: String,
    val arrivalCode: String,
    val arrivalTime: String,
    val duration: String,
    val price: String,
    val promoCode: String,
)