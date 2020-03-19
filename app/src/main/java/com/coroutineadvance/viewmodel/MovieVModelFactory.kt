package com.coroutineadvance.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coroutineadvance.network.MovieRepo
import javax.inject.Inject

class MovieVModelFactory @Inject constructor(val repository: MovieRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepo::class.java).newInstance(repository)
    }
}