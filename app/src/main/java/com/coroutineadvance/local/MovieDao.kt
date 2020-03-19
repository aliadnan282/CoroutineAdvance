package com.coroutineadvance.local

import androidx.room.Dao
import com.coroutineadvance.model.MovieModel
import kotlinx.coroutines.flow.Flow

@Dao

interface MovieDao {
    fun getAllMovies(): Flow<MovieModel>
}