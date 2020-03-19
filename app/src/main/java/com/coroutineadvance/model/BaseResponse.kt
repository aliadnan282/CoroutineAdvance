package com.coroutineadvance.model

import com.google.gson.annotations.SerializedName

abstract class BaseResponse(
    @field:SerializedName("http_response")
    val httpResponse : Int? = 0,

    @field:SerializedName("code")
    val code: String? = "",

    @field:SerializedName("success")
    val success: Boolean = false,

    @field:SerializedName("cmd")
    val cmd: String? = "",

    @field:SerializedName("message")
    var message: String? = "",

    @field:SerializedName("title")
    var title: String? = ""
)