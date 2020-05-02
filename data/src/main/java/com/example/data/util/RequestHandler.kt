package com.example.data.util

import com.example.data.entities.ApiError
import com.google.gson.Gson
import kotlinx.coroutines.coroutineScope
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class RequestHandler {

    suspend fun <T> makeRequest(response: Response<T>): T? {
        return coroutineScope {
            try {
                response.run {
                    if (isSuccessful) {
                        body()
                    } else {
                        throw Exception(responseError(errorBody()))
                    }
                }
            } catch (e: Exception) {
                throw Exception(
                    when (e) {
                        is HttpException -> HTTP_ERROR
                        is UnknownHostException -> NETWORK_ERROR
                        is SocketTimeoutException -> SOCKET_ERROR
                        else -> UNKNOWN_ERROR
                    }
                )
            }
        }
    }

    private fun responseError(responseError: ResponseBody?): String? {
        return extractError(
            Gson().fromJson(responseError?.string(), ApiError::class.java)
        )
    }

    private fun extractError(apiError: ApiError?): String? {
        return if (!apiError?.errors.isNullOrEmpty()) {
            apiError?.errors?.joinToString("\n")
        } else {
            apiError?.message
        }
    }
}