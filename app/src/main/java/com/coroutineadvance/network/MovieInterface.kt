package com.coroutineadvance.network

import com.coroutineadvance.model.MovieModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

public interface MovieInterface {
    @Headers("Content-Type:application/json; charset=UTF-8",
        "authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNjVmNDFjNDFlYmE2YzkxOGZkNzQwZmI1NDgyMmVmMSIsInN1YiI6IjVlNDkzOWMzOWI4NjE2MDAxNjYxYTliOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.P3fhml8kfAoceGEg8f_mZXdhF-ynBS1mqwmqcqKjvuw")    @GET
    fun getPagedMovie(@Url url: String): Deferred<Response<MovieModel>>
}