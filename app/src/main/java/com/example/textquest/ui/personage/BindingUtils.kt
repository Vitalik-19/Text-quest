package com.example.textquest.ui.personage

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.textquest.database.Personage

@BindingAdapter("namePersonage")
fun TextView.setNamePersonage(item: Personage?) {
    item?.let {
        text = item.firstNamePersonage
    }
}