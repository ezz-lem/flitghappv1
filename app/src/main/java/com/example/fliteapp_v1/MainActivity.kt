package com.example.fliteapp_v1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFlights: RecyclerView
    private lateinit var flightAdapter: FlightAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        loadFlightData()
    }

    private fun setupRecyclerView() {
        rvFlights = findViewById(R.id.Flights)
        rvFlights.layoutManager = LinearLayoutManager(this)
        flightAdapter = FlightAdapter(emptyList()) { flight ->
            navigateToETicketActivity(flight)
        }
        rvFlights.adapter = flightAdapter
    }

    // Pass individual data items as Intent extras
    private fun navigateToETicketActivity(flight: FlightData) {
        val intent = Intent(this, ETicketActivity::class.java)

        // Pass data from FlightData
        intent.putExtra("AIRLINE_NAME", flight.airlineName)
        intent.putExtra("AIRLINE_LOGO_RES_ID", flight.airlineLogo) // Resource IDs are integers
        intent.putExtra("FROM_CODE", flight.departureCode)
        intent.putExtra("FROM_AIRPORT", "Delhi International Airport") // Static value
        intent.putExtra("TO_CODE", flight.arrivalCode)
        intent.putExtra("TO_AIRPORT", "Bengaluru Airport India")     // Static value
        intent.putExtra("DURATION", flight.duration)

        // Pass other static/default values for e-ticket specifics
        intent.putExtra("DATE", "20 December 2022")
        intent.putExtra("PASSENGERS", "01 Adult")
        intent.putExtra("PASSENGER_NAME", "Shreya Kumar")
        intent.putExtra("FLIGHT_TYPE", "Economy")
        intent.putExtra("FLIGHT_CODE", "IG-2105")
        intent.putExtra("BOARDING_TIME", "06:15 AM")
        intent.putExtra("GATE", "A5")
        intent.putExtra("TERMINAL", "T2")
        intent.putExtra("SEAT_NUMBER", "A5")
        intent.putExtra("BARCODE_NUMBER", "1 2 5 8 4 6 2 4 2 7 5 3 1 3 5 0 6 7 5 9")
        intent.putExtra("TERMS", "Curabitur ultrices nisl ac vulputate lacinia. Donec pharetra tincidunt velit, sed iaculis est sollicitudin ac.")

        startActivity(intent)
    }

    private fun loadFlightData() {
        val flights = listOf(
            FlightData(
                "Indigo", R.drawable.indigo,
                "DEL", "06:30", "BLR", "10:45",
                "04h 15m", "7,319",
                "Use Code : Flyaway60 and get 60% instant cashback"
            ),
            FlightData(
                "Vistara", R.drawable.vistara,
                "DEL", "07:15", "BLR", "09:40",
                "02h 25m", "8,500",
                "Use Code : Flyaway60 and get 60% instant cashback"
            ),
            FlightData(
                "Spicejet", R.drawable.spicejet,
                "DEL", "07:55", "BLR", "10:05",
                "02h 10m", "7,000",
                "Use Code : GIUNIQUE and get Rs.250 instant discount"
            ),
            FlightData(
                "Indigo", R.drawable.indigo,
                "DEL", "08:45", "BLR", "11:10",
                "02h 25m", "7,400",
                "Use Code : Flyaway60 and get 60% instant cashback"
            ),
            FlightData(
                "Emirates", R.drawable.emirates,
                "DEL", "10:00", "BLR", "12:15",
                "02h 15m", "12,000",
                "Use Code : GIUNIQUE and get Rs.250 instant discount"
            ),
            FlightData(
                "Air India", R.drawable.indigo,
                "DEL", "11:30", "BLR", "14:00",
                "02h 30m", "9,200",
                "Book now and save!"
            )
        )

        flightAdapter.updateFlights(flights)
    }
}