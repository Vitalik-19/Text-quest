package com.example.textquest.ui.personage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.R
import com.example.textquest.database.Personage
import com.example.textquest.databinding.ItemPersonageBinding

class PersonageAdapter(val clickListener: PersonageListener) : ListAdapter<Personage, PersonageAdapter.ViewHolder>(PersonageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    class ViewHolder private constructor(val binding: ItemPersonageBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemPersonageButton = binding.itemListPersonageButton
        private val informationPersonageButton = binding.informationPersonageButton

        fun bind(clickListener: PersonageListener, item: Personage) {
            binding.personage = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
            val args = Bundle()
            args.putLong("key", item.idPersonage)
            itemPersonageButton.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_personageFragment_to_chaptersFragment, args))
//            informationPersonageButton.setOnClickListener(
//                    Navigation.createNavigateOnClickListener(R.id.action_personageFragment_to_informationPersonageFragment, args))
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPersonageBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
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

class PersonageListener(val clickListener: (idPersonage: Long) -> Unit) {
    fun onClick(personage: Personage) = clickListener(personage.idPersonage)
}
