package com.example.fliteapp_v1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ETicketActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var ivAirlineLogo: ImageView
    private lateinit var tvDate: TextView
    private lateinit var tvFromCode: TextView
    private lateinit var tvFromAirport: TextView
    private lateinit var tvToCode: TextView
    private lateinit var tvToAirport: TextView
    private lateinit var tvDuration: TextView
    private lateinit var tvPassengers: TextView
    private lateinit var tvPassengerName: TextView
    private lateinit var tvFlightType: TextView
    private lateinit var tvFlightCode: TextView
    private lateinit var tvBoardingTime: TextView
    private lateinit var tvGate: TextView
    private lateinit var tvTerminal: TextView
    private lateinit var tvSeatNumber: TextView
    private lateinit var ivBarcode: ImageView
    private lateinit var tvBarcodeNumber: TextView
    private lateinit var tvTerms: TextView
    private lateinit var btnDownload: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eticket)

        findViews()

        // Retrieve data from Intent extras with null safety
        // Use the Elvis operator (?:) to provide default values if extras are missing or null
        val airlineName = intent.getStringExtra("AIRLINE_NAME") ?: ""
        val airlineLogoResId = intent.getIntExtra("AIRLINE_LOGO_RES_ID", R.drawable.indigo2) // Provide a default resource ID
        val date = intent.getStringExtra("DATE") ?: ""
        val fromCode = intent.getStringExtra("FROM_CODE") ?: ""
        val fromAirport = intent.getStringExtra("FROM_AIRPORT") ?: ""
        val toCode = intent.getStringExtra("TO_CODE") ?: ""
        val toAirport = intent.getStringExtra("TO_AIRPORT") ?: ""
        val duration = intent.getStringExtra("DURATION") ?: ""
        val passengers = intent.getStringExtra("PASSENGERS") ?: ""
        val passengerName = intent.getStringExtra("PASSENGER_NAME") ?: ""
        val flightType = intent.getStringExtra("FLIGHT_TYPE") ?: ""
        val flightCode = intent.getStringExtra("FLIGHT_CODE") ?: ""
        val boardingTime = intent.getStringExtra("BOARDING_TIME") ?: ""
        val gate = intent.getStringExtra("GATE") ?: ""
        val terminal = intent.getStringExtra("TERMINAL") ?: ""
        val seatNumber = intent.getStringExtra("SEAT_NUMBER") ?: ""
        val barcodeNumber = intent.getStringExtra("BARCODE_NUMBER") ?: ""
        val terms = intent.getStringExtra("TERMS") ?: ""

        // Populate views with retrieved data
        // Set the airline logo using the retrieved resource ID
        ivAirlineLogo.setImageResource(airlineLogoResId)
        // Set the text for other views using the retrieved strings
        tvDate.text = date
        tvFromCode.text = fromCode
        tvFromAirport.text = fromAirport
        tvToCode.text = toCode
        tvToAirport.text = toAirport
        tvDuration.text = duration
        tvPassengers.text = passengers
        tvPassengerName.text = passengerName
        tvFlightType.text = flightType
        tvFlightCode.text = flightCode
        tvBoardingTime.text = boardingTime
        tvGate.text = gate
        tvTerminal.text = terminal
        tvSeatNumber.text = seatNumber
        tvBarcodeNumber.text = barcodeNumber
        tvTerms.text = terms

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnDownload.setOnClickListener {
            // Add download logic here
        }
    }

    private fun findViews() {
        btnBack = findViewById(R.id.btnBack)
        ivAirlineLogo = findViewById(R.id.ivAirlineLogo)
        tvDate = findViewById(R.id.tvDate)
        tvFromCode = findViewById(R.id.tvFromCode)
        tvFromAirport = findViewById(R.id.tvFromAirport)
        tvToCode = findViewById(R.id.tvToCode)
        tvToAirport = findViewById(R.id.tvToAirport)
        tvDuration = findViewById(R.id.tvDuration)
        tvPassengers = findViewById(R.id.tvPassengers)
        tvPassengerName = findViewById(R.id.tvPassengerName)
        tvFlightType = findViewById(R.id.tvFlightType)
        tvFlightCode = findViewById(R.id.tvFlightCode)
        tvBoardingTime = findViewById(R.id.tvBoardingTime)
        tvGate = findViewById(R.id.tvGate)
        tvTerminal = findViewById(R.id.tvTerminal)
        tvSeatNumber = findViewById(R.id.tvSeatNumber)
        ivBarcode = findViewById(R.id.ivBarcode)
        tvBarcodeNumber = findViewById(R.id.tvBarcodeNumber)
        tvTerms = findViewById(R.id.tvTerms)
        btnDownload = findViewById(R.id.btnDownload)
    }
}