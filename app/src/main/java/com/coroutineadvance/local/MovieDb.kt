package com.coroutineadvance.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MovieDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private const val DATABASE_NAME = "movie_db"
        fun buildDatabase(context: Context): MovieDb {
            return Room.databaseBuilder(context, MovieDb::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}