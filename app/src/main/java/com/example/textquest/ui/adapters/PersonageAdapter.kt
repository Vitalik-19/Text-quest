package com.example.textquest.ui.newGame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.R
import com.example.textquest.ui.Personage
import com.example.textquest.ui.idPersonage
import com.example.textquest.ui.idQuestion

class PersonageAdapter(val personage: List<Personage>) : RecyclerView.Adapter<PersonageAdapter.personageViewHolder>() {

    class personageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personageButton: LinearLayout = itemView.findViewById(R.id.item_list_personage_button)
        val namePersonage: TextView = itemView.findViewById(R.id.item_list_name_personage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): personageViewHolder {
        val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_personage, parent, false)
        return personageViewHolder(view)
    }

    override fun getItemCount() = personage.size

    override fun onBindViewHolder(holder: personageViewHolder, position: Int) {
        val item = personage[position]
        holder.namePersonage.text = item.firsName

        with(holder.personageButton) {
            tag = item
            setOnClickListener {
                idPersonage = position
                idQuestion = 0
                it.findNavController().navigate(R.id.action_newGameFragment_to_personageNoteFragment)
            }
        }
    }
}