package com.example.data.util

import kotlinx.coroutines.coroutineScope
import retrofit2.Response

open class RequestHandler {

    suspend fun <T> makeRequest(response: Response<T>): T? {
        return coroutineScope {
            try {
                response.run {
                    if (isSuccessful) {
                        body()
                    } else {
                        throw Throwable()
                    }
                }
            } catch (e: Exception) {
                throw e
            }
        }
    }
}