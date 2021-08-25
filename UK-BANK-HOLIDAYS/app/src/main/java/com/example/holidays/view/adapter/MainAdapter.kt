package com.example.holidays.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.holidays.databinding.AdapterHolidayBinding
import com.example.holidays.model.Event

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var events = mutableListOf<Event>()

    fun setEventList(movies: List<Event>) {
        this.events = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        var binding = AdapterHolidayBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val event = events[position]
        holder.binding.name.text = event.title
        holder.binding.date.text = event.date
    }

    override fun getItemCount(): Int {
        return events.size
    }
}

class MainViewHolder(val binding: AdapterHolidayBinding) : RecyclerView.ViewHolder(binding.root) {

}