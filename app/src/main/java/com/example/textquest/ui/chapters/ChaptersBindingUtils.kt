package com.example.textquest.ui.chapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.textquest.database.Chapter

@BindingAdapter("nameChapter")
fun TextView.setNameChapter(item: Chapter?) {
    item?.let {
        text = item.nameChapter
    }
}
@BindingAdapter("numberChapter")
fun TextView.setNumberChapter(item: Chapter?) {
    item?.let {
        text = item.chapterId.toString()
    }
}