package com.example.textquest.ui.new_game_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.R
import com.example.textquest.ui.Personage

class PersonageAdapter(val personage: List<Personage>) : RecyclerView.Adapter<PersonageAdapter.personageViewHolder>() {


    class personageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personageButton: Button = itemView.findViewById(R.id.name_personage_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): personageViewHolder {
        val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_personage, parent, false)

        val personageButton: Button = view.findViewById(R.id.name_personage_button)
        personageButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_newGameFragment_to_personageNoteFragment)
        }
        return personageViewHolder(view)
    }

    override fun getItemCount() = personage.size

    override fun onBindViewHolder(holder: personageViewHolder, position: Int) {
       val item = personage[position]
        holder.personageButton.text = item.firsName
    }
}