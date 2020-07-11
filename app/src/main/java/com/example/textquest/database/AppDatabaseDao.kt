package com.example.textquest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
public interface AppDatabaseDao {

    // Добавление personage в бд
    @Insert
    fun insert(personage: Personage)

    // Удаление personage из бд
    @Query("DELETE FROM Personage WHERE idPersonage = :key")
    fun clear(key: Long)

    // Обновление personage в бд
    @Update
    fun update(personage: Personage)

    @Query("SELECT * from Personage WHERE idPersonage = :key")
    fun get(key: Long): Personage?
}