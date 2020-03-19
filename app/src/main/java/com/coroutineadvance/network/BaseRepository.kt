package com.coroutineadvance.network

import com.coroutineadvance.model.ErrorResponse
import com.coroutineadvance.model.ResponseModel
import com.coroutineadvance.model.ResponseType
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Response

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>) :  ResponseModel?{
        val result = newsApiOutput(call)
        var output : ResponseModel? = null
        when(result){
            is ResponseType.Success ->
                output = ResponseModel(result.data, null)
           is ResponseType.Error -> ResponseModel(null,result.exception)
        }
        return output

    }
    private suspend fun<T : Any> newsApiOutput(call: suspend()-> Response<T>) : ResponseType<T>{
        val response = call.invoke()
        return if (response.isSuccessful) {
            ResponseType.Success(response.body()!!)
        }else{
            val jObjError = JSONObject(response.errorBody()?.string())
            val errorResponse = Gson().fromJson<ErrorResponse>(jObjError.toString(), ErrorResponse::class.java)
            return ResponseType.Error(errorResponse)
        }
       /* else{
            if (response.code() == 403 || response.code() == 801) {
                *//* if (UserSession.isLoggedIn()){
                     UserSession.logOut403()
                 }*//*
            }
            try {

                val jObjError = JSONObject(response.errorBody()?.string())
                val errorResponse = Gson().fromJson<ErrorResponse>(jObjError.toString(), ErrorResponse::class.java)
                return ResponseType.Error(errorResponse)
            } catch (exception: Exception) {
                exception.printStackTrace()
                val errorResponse = ErrorResponse()
                if (exception is UnknownHostException) {
                    errorResponse.message = EnumErrorMessages.SOMETHING_WRONG.identifer
                    return BaseResult.Error(errorResponse)
                }
                if (response.code() in 500..510)
                    errorResponse.message = EnumErrorMessages.API_SERVER_ERROR.identifer
                else if (response.code() in 401..403)
                    errorResponse.message = EnumErrorMessages.API_AUTHENTICATION_ERROR.identifer
                else
                    errorResponse.message = EnumErrorMessages.SOMETHING_WRONG.identifer
                return BaseResult.Error(errorResponse)
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            val errorResponse = ErrorResponse()
            if (exception is UnknownHostException) {
                errorResponse.message = EnumErrorMessages.SOMETHING_WRONG.identifer
                return BaseResult.Error(errorResponse)
            }
            else if (exception is SocketTimeoutException){
                errorResponse.message = EnumErrorMessages.API_TIME_OUT_ERROR.identifer
                return BaseResult.Error(errorResponse)
            }
            errorResponse.message = EnumErrorMessages.SOMETHING_WRONG.identifer
            return BaseResult.Error(errorResponse)
        }
        }
*/
    }
}