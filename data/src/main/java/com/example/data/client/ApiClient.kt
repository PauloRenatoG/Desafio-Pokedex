package com.example.data.client

import javax.inject.Inject

class ApiClient @Inject constructor(
    private val apiService: ApiService
) {
}