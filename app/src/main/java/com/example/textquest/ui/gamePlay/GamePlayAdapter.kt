package com.example.textquest.ui.gamePlay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.database.Answer
import com.example.textquest.databinding.ItemAnswerBinding

class GamePlayAdapter(val clickListener: GamePlayListener) : ListAdapter<Answer, GamePlayAdapter.ViewHolder>(GamePlayDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }


    class ViewHolder(val binding: ItemAnswerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: GamePlayListener, item: Answer) {
            binding.answer = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemAnswerBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class GamePlayDiffCallback : DiffUtil.ItemCallback<Answer>() {
    override fun areItemsTheSame(oldItem: Answer, newItem: Answer): Boolean {
        return oldItem.answerId == newItem.answerId
    }

    override fun areContentsTheSame(oldItem: Answer, newItem: Answer): Boolean {
        return oldItem == newItem
    }
}

class GamePlayListener(val clickListener: (answerId: Long) -> Unit) {
    fun onClick(answer: Answer) = clickListener(answer.answerId)
}