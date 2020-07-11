package com.example.textquest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
public interface AppDatabaseDao {

    // Добавление advert в бд
    @Insert
    fun insert(personage: Personage)

    // Удаление advert из бд
    @Query("DELETE FROM Personage WHERE idPersonage = :key")
    fun clear(key: Long)

    // Обновление advert в бд
    @Update
    fun update(personage: Personage)
}