package com.example.textquest.ui.personage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.R
import com.example.textquest.database.Personage

class PersonageAdapter : ListAdapter<Personage, PersonageAdapter.ViewHolder>(PersonageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemPersonageButton: LinearLayout = itemView.findViewById(R.id.item_list_personage_button)
        private val informationPersonageButton: ImageButton = itemView.findViewById(R.id.information_personage_button)
        private val namePersonage: TextView = itemView.findViewById(R.id.item_list_name_personage)

        fun bind(item: Personage) {
            val args = Bundle()
            args.putLong("key", item.idPersonage)
            namePersonage.text = item.firstNamePersonage
            itemPersonageButton.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_personageFragment_to_chaptersFragment, args))
            informationPersonageButton.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_personageFragment_to_informationPersonageFragment, args))
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_personage, parent, false)
                return ViewHolder(view)
            }
        }
    }
}

class PersonageDiffCallback : DiffUtil.ItemCallback<Personage>() {
    override fun areItemsTheSame(oldItem: Personage, newItem: Personage): Boolean {
        return oldItem.idPersonage == newItem.idPersonage
    }

    override fun areContentsTheSame(oldItem: Personage, newItem: Personage): Boolean {
        return oldItem == newItem
    }
}