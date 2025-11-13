package com.example.fliteapp_v1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlightAdapter(
    private var flights: List<FlightData>,
    private val onFlightClick: (FlightData) -> Unit
) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    class FlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivAirlineLogo: ImageView = view.findViewById(R.id.ivAirlineLogo)
        val tvAirlineName: TextView? = view.findViewById(R.id.AirlineName)
        val tvDepartureCode: TextView? = view.findViewById(R.id.DepartureCode)
        val tvDepartureTime: TextView? = view.findViewById(R.id.DepartureTime)
        val tvArrivalCode: TextView? = view.findViewById(R.id.ArrivalCode)
        val tvArrivalTime: TextView? = view.findViewById(R.id.ArrivalTime)
        val tvFlightDuration: TextView? = view.findViewById(R.id.FlightDuration)
        val tvPrice: TextView = view.findViewById(R.id.Price)
        val tvPromoCode: TextView = view.findViewById(R.id.PromoCode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flight, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flights[position]

        holder.ivAirlineLogo.setImageResource(flight.airlineLogo)
        holder.tvAirlineName!!.text = flight.airlineName
        holder.tvDepartureCode!!.text = flight.departureCode
        holder.tvDepartureTime!!.text = flight.departureTime
        holder.tvArrivalCode!!.text = flight.arrivalCode
        holder.tvArrivalTime!!.text = flight.arrivalTime
        holder.tvFlightDuration!!.text = flight.duration
        holder.tvPrice.text = flight.price
        holder.tvPromoCode.text = flight.promoCode

        holder.itemView.setOnClickListener {
            onFlightClick(flight)
        }
    }

    override fun getItemCount() = flights.size

    fun updateFlights(newFlights: List<FlightData>) {
        flights = newFlights
        notifyDataSetChanged()
    }
}