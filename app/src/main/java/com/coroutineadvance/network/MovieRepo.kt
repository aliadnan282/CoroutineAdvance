package com.coroutineadvance.network

import com.coroutineadvance.model.ResponseModel
import javax.inject.Inject

class MovieRepo @Inject constructor(var movieInterface: MovieInterface): BaseRepository()  {

    suspend fun getMovieList(): ResponseModel? {
        val url="https://api.themoviedb.org/4/list/349?page=1&api_key=165f41c41eba6c918fd740fb54822ef1"
        return safeApiCall { movieInterface.getPagedMovie(url).await() }
    }
}