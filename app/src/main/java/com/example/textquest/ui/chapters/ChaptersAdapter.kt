package com.example.textquest.ui.chapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.database.Chapter
import com.example.textquest.databinding.ItemChapterBinding

class ChaptersAdapter : ListAdapter<Chapter, ChaptersAdapter.ViewHolder>(ChaptersDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(val binding: ItemChapterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Chapter) {
            binding.chaptersNumber.text = "Chapter ${item.chapterId}"
            binding.chaptersName.text = item.nameChapter
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                //todo to connect binding adapter
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemChapterBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class ChaptersDiffCallback : DiffUtil.ItemCallback<Chapter>() {
    override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
        return oldItem.chapterId == newItem.chapterId
    }

    override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
        return oldItem == newItem
    }

}