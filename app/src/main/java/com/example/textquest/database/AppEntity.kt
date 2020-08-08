package com.example.textquest.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

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
        val nameChapter: String = "",
        val ownerId: Long = 0
)

data class PersonageWithChapters(
        @Embedded val personage: Personage,
        @Relation(
                parentColumn = "personageId",
                entity = Chapter::class,
                entityColumn = "ownerId")
        val chapters: List<Chapter>
)
