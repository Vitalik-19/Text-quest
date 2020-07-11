package com.example.textquest.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personage(
    @PrimaryKey(autoGenerate = true)
    val idPersonage: Long,
    val firstNamePersonage: String,
    val descriptionPersonage: String
)