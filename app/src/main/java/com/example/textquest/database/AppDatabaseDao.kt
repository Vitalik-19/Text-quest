package com.example.textquest.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
public interface AppDatabaseDao {

    //implemented for Personage entity

    // Добавление personage в бд
    @Insert
    fun insert(personage: Personage)

    // Удаление personage из бд
    @Query("DELETE FROM Personage WHERE personageId = :key")
    fun clearPersonage(key: Long)

    // Обновление personage в бд
    @Update
    fun update(personage: Personage)

    @Query("SELECT * from Personage")
    fun getPersonages(): LiveData<List<Personage>>

    @Query("SELECT * from Personage WHERE personageId = :key")
    fun getPersonage(key: Long): Personage?

    //implemented for Chapter entity
    @Insert
    fun insert(chapter: Chapter)

    @Query("DELETE FROM Chapter WHERE chapterId = :key")
    fun clearChapter(key: Long)

    @Update
    fun update(chapter: Chapter)

    @Query("SELECT * from Chapter")
    fun getChapters(): LiveData<List<Chapter>>

    @Query("SELECT * from Chapter WHERE chapterId = :key")
    fun getChapter(key: Long): Chapter?

}