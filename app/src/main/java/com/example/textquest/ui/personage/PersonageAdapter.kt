package com.example.textquest.ui.personage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.R
import com.example.textquest.database.Personage

class PersonageAdapter : RecyclerView.Adapter<PersonageAdapter.NewGameViewHolder>() {
    var data = listOf<Personage>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class NewGameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personageButton: LinearLayout = itemView.findViewById(R.id.item_list_personage_button)
        val namePersonage: TextView = itemView.findViewById(R.id.item_list_name_personage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewGameViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_personage, parent, false)
        return PersonageAdapter.NewGameViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NewGameViewHolder, position: Int) {

        holder.namePersonage.text = data[position].firstNamePersonage

//        with(holder.personageButton) {
//            tag = data[position]
//            setOnClickListener {
//                idPersonage = position
//                idQuestion = 0
//                it.findNavController().navigate(R.id.action_newGameFragment_to_personageNoteFragment)
//            }
//        }
    }

}