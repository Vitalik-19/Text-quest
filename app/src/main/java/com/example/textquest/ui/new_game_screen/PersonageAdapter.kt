package com.example.textquest.ui.new_game_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.R

class PersonageAdapter(val personage: ArrayList<String>) : RecyclerView.Adapter<PersonageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_personage, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = personage.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.firstName.text = personage[position]
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: Button = itemView.findViewById(R.id.name_personage_button)

    }
}