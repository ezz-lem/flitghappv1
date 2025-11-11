package com.example.fliteapp_v1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TicketData(
    val airlineName: String,
    val airlineLogo: Int,
    val date: String,
    val fromCode: String,
    val fromAirport: String,
    val toCode: String,
    val toAirport: String,
    val duration: String,
    val passengers: String,
    val hasMeal: Boolean,
    val passengerName: String,
    val flightType: String,
    val flightCode: String,
    val boardingTime: String,
    val gate: String,
    val terminal: String,
    val seatNumber: String,
    val barcodeNumber: String,
    val terms: String
) : Parcelable