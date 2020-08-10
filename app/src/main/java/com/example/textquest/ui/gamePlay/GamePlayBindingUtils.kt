package com.example.textquest.ui.gamePlay

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.textquest.database.Answer

@BindingAdapter ("textAnswer")
fun TextView.setTextAnswer(item: Answer?) {
    item?.let {
        text = item.textAnswer
    }
}