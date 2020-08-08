package com.example.textquest.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
public abstract class AppDatabaseDao {

    //implemented for Personage entity

    // Добавление personage в бд
    @Insert
    abstract fun insert(personage: Personage)

    // Удаление personage из бд
    @Query("DELETE FROM Personage WHERE personageId = :key")
    abstract fun clearPersonage(key: Long)

    // Обновление personage в бд
    @Update
    abstract fun update(personage: Personage)

    @Query("SELECT * from Personage")
    abstract fun getPersonages(): LiveData<List<Personage>>

    @Query("SELECT * from Personage WHERE personageId = :key")
    abstract fun getPersonage(key: Long): Personage?

    //implemented for Chapter entity
    @Insert
    abstract fun insert(chapter: Chapter)

    @Query("DELETE FROM Chapter WHERE chapterId = :key")
    abstract fun clearChapter(key: Long)

    @Update
    abstract fun update(chapter: Chapter)

    @Query("SELECT * from Chapter")
    abstract fun getChapters(): LiveData<List<Chapter>>

    @Query("SELECT * from Chapter WHERE chapterId = :key")
    abstract fun getChapter(key: Long): Chapter?

    //implemented for GamePlay entity
    @Insert
    abstract fun insert(gamePlay: GamePlay)

    @Query("DELETE FROM GamePlay WHERE gamePlayId = :key")
    abstract fun clearGamePlay(key: Long)

    @Update
    abstract fun update(gamePlay: GamePlay)

    @Query("SELECT * from GamePlay")
    abstract fun getGamePlays(): LiveData<List<GamePlay>>

    @Query("SELECT * from GamePlay WHERE gamePlayId = :key")
    abstract fun getGamePlay(key: Long): GamePlay?

    //    Entity linking
    @Transaction
    @Query("SELECT * FROM Personage WHERE personageId = :key")
    abstract fun getPersonageWithChapters(key: Long): PersonageWithChapters?

    @Transaction
    @Query("SELECT * FROM Chapter WHERE chapterId = :key")
    abstract fun getChapterWithGamePlays(key: Long): ChapterWithGamePlays?

}