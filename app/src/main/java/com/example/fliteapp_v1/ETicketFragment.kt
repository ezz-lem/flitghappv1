package com.example.fliteapp_v1

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ETicketFragment : Fragment() {

    private lateinit var ticketData: TicketData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get ticket data from arguments
        ticketData = arguments?.getParcelable("TICKET_DATA") ?: return

        setupViews(view)
        populateData()
    }

    private fun setupViews(view: View) {
        view.findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            requireActivity().onBackPressed()
        }

        view.findViewById<Button>(R.id.btnDownload).setOnClickListener {
            downloadTicket()
        }
    }

    private fun populateData() {
        view?.apply {
            findViewById<ImageView>(R.id.ivAirlineLogo).setImageResource(ticketData.airlineLogo)
            findViewById<TextView>(R.id.tvDate).text = ticketData.date
            findViewById<TextView>(R.id.tvFromCode).text = ticketData.fromCode
            findViewById<TextView>(R.id.tvFromAirport).text = ticketData.fromAirport
            findViewById<TextView>(R.id.tvToCode).text = ticketData.toCode
            findViewById<TextView>(R.id.tvToAirport).text = ticketData.toAirport
            findViewById<TextView>(R.id.tvDuration).text = ticketData.duration
            findViewById<TextView>(R.id.tvPassengers).text = ticketData.passengers
            findViewById<TextView>(R.id.tvPassengerName).text = ticketData.passengerName
            findViewById<TextView>(R.id.tvFlightType).text = ticketData.flightType
            findViewById<TextView>(R.id.tvFlightCode).text = ticketData.flightCode
            findViewById<TextView>(R.id.tvBoardingTime).text = ticketData.boardingTime
            findViewById<TextView>(R.id.tvGate).text = ticketData.gate
            findViewById<TextView>(R.id.tvTerminal).text = ticketData.terminal
            findViewById<TextView>(R.id.tvSeatNumber).text = ticketData.seatNumber
            findViewById<TextView>(R.id.tvBarcodeNumber).text = ticketData.barcodeNumber
            findViewById<TextView>(R.id.tvTerms).text = ticketData.terms
        }
    }

    private fun downloadTicket() {
        // Here you would implement actual download logic
        // For now, just show success dialog
        showSuccessDialog()
    }

    private fun showSuccessDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_success)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        val btnOk = dialog.findViewById<Button>(R.id.btnOk)
        btnOk.setOnClickListener {
            dialog.dismiss()
            requireActivity().onBackPressed() // Go back to flight list
        }

        dialog.show()
    }

    companion object {
        fun newInstance(ticketData: TicketData): ETicketFragment {
            val fragment = ETicketFragment()
            val args = Bundle()
            args.putParcelable("TICKET_DATA", ticketData)
            fragment.arguments = args
            return fragment
        }
    }
}