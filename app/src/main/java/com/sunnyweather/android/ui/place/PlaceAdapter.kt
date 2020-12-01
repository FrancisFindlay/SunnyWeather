package com.sunnyweather.android.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunnyweather.android.R
import com.sunnyweather.android.logic.model.Place
import kotlinx.android.synthetic.main.place_item.view.*

class PlaceAdapter(private val data: List<Place>) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHoler>() {

    class PlaceViewHoler(view: View) : RecyclerView.ViewHolder(view) {
        val placeName: TextView = view.findViewById(R.id.placeName)
        val placeAddress: TextView = view.findViewById(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.PlaceViewHoler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlaceViewHoler(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PlaceAdapter.PlaceViewHoler, position: Int) {
        val adapterPosition = holder.adapterPosition
        val place = data[adapterPosition]
        holder.placeName.text = place.name.toString()
        holder.placeAddress.text = place.address.toString()
    }
}