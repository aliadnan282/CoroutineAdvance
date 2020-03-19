package com.coroutineadvance.model

sealed class ResponseType<out T>{
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    data class Success<out T>(val data: T): ResponseType<T>()
    data class Error(val exception: ErrorResponse) : ResponseType<Nothing>( )
}