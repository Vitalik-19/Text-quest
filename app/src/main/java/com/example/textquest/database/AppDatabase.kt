package com.example.textquest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Personage::class, Chapter::class,
    GamePlay::class, Answer::class], version = 7, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract val appDatabaseDao: AppDatabaseDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            val MIGRATION_1_2 = object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("CREATE TABLE Chapter(chapterId INTEGER PRIMARY KEY NOT NULL DEFAULT 0 )")
                }
            }

            val MIGRATION_2_3 = object : Migration(2, 3) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE Chapter ADD COLUMN nameChapter TEXT NOT NULL DEFAULT ''")
                }
            }

            val MIGRATION_3_4 = object : Migration(3, 4) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE Chapter ADD COLUMN ownerId INTEGER NOT NULL DEFAULT 0")
                }
            }

            val MIGRATION_4_5 = object : Migration(4, 5) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("CREATE TABLE GamePlay(" +
                            "gamePlayId INTEGER PRIMARY KEY NOT NULL DEFAULT 0," +
                            " textStory TEXT NOT NULL DEFAULT ''," +
                            " ownerId INTEGER NOT NULL DEFAULT 0)")
                }
            }
            val MIGRATION_5_6 = object : Migration(5, 6) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("CREATE TABLE Answer(" +
                            "answerId INTEGER PRIMARY KEY NOT NULL DEFAULT 0," +
                            " textAnswer TEXT NOT NULL DEFAULT ''," +
                            " navigationToGamePlayId INTEGER NOT NULL DEFAULT 0," +
                            " ownerGamePlayId INTEGER NOT NULL DEFAULT 0)")
                }
            }
            val MIGRATION_6_7 = object : Migration(6, 7) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE Answer ADD COLUMN navigationToChapterId INTEGER NOT NULL DEFAULT 0")
                }
            }

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext, AppDatabase::class.java, "database.db")
                            .createFromAsset("database/database.db")
                            .addMigrations(MIGRATION_1_2, MIGRATION_2_3,
                                    MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7)
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}