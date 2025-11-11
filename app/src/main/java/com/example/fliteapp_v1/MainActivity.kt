package com.example.fliteapp_v1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    private lateinit var rvFlights: RecyclerView
    private lateinit var flightAdapter: FlightAdapter
    private lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainer = findViewById(R.id.fragmentContainer)
        setupRecyclerView()
        loadFlightData()
    }

    private fun setupRecyclerView() {
        rvFlights = findViewById(R.id.Flights)
        rvFlights.layoutManager = LinearLayoutManager(this)
        flightAdapter = FlightAdapter(emptyList()) { flight ->
            navigateToETicket(flight)
        }
        rvFlights.adapter = flightAdapter
    }

    private fun navigateToETicket(flight: FlightData) {
        val ticketData = TicketData(
            airlineName = flight.airlineName,
            airlineLogo = flight.airlineLogo,
            date = "20 December 2022",
            fromCode = flight.departureCode,
            fromAirport = "Delhi International Airport",
            toCode = flight.arrivalCode,
            toAirport = "Bengaluru Airport India",
            duration = flight.duration,
            passengers = "01 Adult",
            hasMeal = true,
            passengerName = "Shreya Kumar",
            flightType = "Economy",
            flightCode = "IG-2105",
            boardingTime = "06:15 AM",
            gate = "A5",
            terminal = "T2",
            seatNumber = "A5",
            barcodeNumber = "1 2 5 8 4 6 2 4 2 7 5 3 1 3 5 0 6 7 5 9",
            terms = "Curabitur ultrices nisl ac vulputate lacinia. Donec pharetra tincidunt velit, sed iaculis est sollicitudin ac."
        )

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ETicketFragment.newInstance(ticketData))
            .addToBackStack(null)
            .commit()
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
                "02h 25m", "7,319",
                "Use Code : Flyaway60 and get 60% instant cashback"
            ),
            FlightData(
                "Spicejet", R.drawable.spicejet,
                "DEL", "07:55", "BLR", "10:05",
                "02h 10m", "7,319",
                "User GIUNIQUE and get Rs.250 instant discount"
            ),
            FlightData(
                "Indigo", R.drawable.indigo,
                "DEL", "08:45", "BLR", "11:10",
                "02h 25m", "7,319",
                "Use Code : Flyaway60 and get 60% instant cashback"
            ),
            FlightData(
                "Emirates", R.drawable.emirates,
                "DEL", "10:00", "BLR", "12:15",
                "02h 15m", "7,319",
                "User GIUNIQUE and get Rs.250 instant discount"
            ),
            FlightData(
                "Indigo", R.drawable.indigo,
                "DEL", "06:30", "BLR", "10:45",
                "04h 15m", "7,319",
                "Use Code : Flyaway60 and get 60% instant cashback"
            )
        )

        flightAdapter.updateFlights(flights)
    }
}