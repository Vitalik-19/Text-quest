package com.example.textquest.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personage(
        @PrimaryKey(autoGenerate = true)
        val personageId: Long = 0,
        val firstNamePersonage: String = "",
        val descriptionPersonage: String = ""
)

@Entity
data class Chapter(
        @PrimaryKey(autoGenerate = true)
        val chapterId: Long = 0,
        val nameChapter: String = ""
)
