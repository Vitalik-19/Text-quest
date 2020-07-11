package com.example.textquest.ui.personage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
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
        val itemPersonageButton: LinearLayout = itemView.findViewById(R.id.item_list_personage_button)
        val informationPersonageButton: ImageButton = itemView.findViewById(R.id.information_personage_button)
        val namePersonage: TextView = itemView.findViewById(R.id.item_list_name_personage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewGameViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_personage, parent, false)
        return NewGameViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NewGameViewHolder, position: Int) {
        val args = Bundle()

        holder.namePersonage.text = data[position].firstNamePersonage
        args.putLong("key", data[position].idPersonage)
        holder.itemPersonageButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_personageFragment_to_chaptersFragment, args))
        holder.informationPersonageButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_personageFragment_to_informationPersonageFragment, args))
    }
}