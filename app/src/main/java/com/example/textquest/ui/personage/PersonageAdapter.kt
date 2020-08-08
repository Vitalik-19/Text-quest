package com.example.textquest.ui.personage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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

        fun bind(clickListener: PersonageListener, item: Personage) {
            binding.personage = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
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
        return oldItem.personageId == newItem.personageId
    }

    override fun areContentsTheSame(oldItem: Personage, newItem: Personage): Boolean {
        return oldItem == newItem
    }
}

class PersonageListener(val clickListener: (buttonId: Int, idPersonage: Long) -> Unit) {
    fun onClick(id: Int, personage: Personage) = clickListener(id, personage.personageId)
}