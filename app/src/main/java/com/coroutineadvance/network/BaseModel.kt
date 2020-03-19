package com.coroutineadvance.network

sealed class BaseModel<out T: Any> {
    data class LOADING<out T: Any>(val data: T): BaseModel<T>()
    data class INPROGRESS <out T: Any>(val data: T): BaseModel<T>()
    data class SUCCESS<out T: Any>(val data: T): BaseModel<T>()
    data class ERROR<out T: Any> (val error: T): BaseModel<Nothing>()
}