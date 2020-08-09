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

@Entity
data class GamePlay(
        @PrimaryKey(autoGenerate = true)
        val gamePlayId: Long = 0,
        val textStory: String = "",
        val ownerId: Long = 0
)

@Entity
data class Answer(
        @PrimaryKey(autoGenerate = true)
        val answerId: Long = 0,
        val textAnswer: String = "",
        val navigationToGamePlayId: Long = 0,
        val ownerGamePlayId: Long = 0
)

data class PersonageWithChapters(
        @Embedded val personage: Personage,
        @Relation(
                parentColumn = "personageId",
                entity = Chapter::class,
                entityColumn = "ownerId"
        )
        val chapters: List<Chapter>
)

data class ChapterWithGamePlays(
        @Embedded val chapter: Chapter,
        @Relation(
                parentColumn = "chapterId",
                entity = GamePlay::class,
                entityColumn = "ownerId"
        )
        val gamePlays: List<GamePlay>
)
data class GamePlayWithAnswers(
        @Embedded val gamePlay: GamePlay,
        @Relation(
                parentColumn = "gamePlayId",
                entity = Answer::class,
                entityColumn = "ownerGamePlayId"
        )
        val answers: List<Answer>
)
