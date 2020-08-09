package com.example.textquest.ui.gamePlay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.textquest.R
import com.example.textquest.database.Answer

class GamePlayAdapter : RecyclerView.Adapter<GamePlayAdapter.ViewHolder>() {
    var data = listOf<Answer>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_answer, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textAnswer.text = data[position].textAnswer
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textAnswer = itemView.findViewById<TextView>(R.id.item_answer_text)
    }
}