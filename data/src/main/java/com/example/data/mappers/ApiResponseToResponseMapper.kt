package com.example.data.mappers

import com.example.data.entities.ApiResponse
import com.example.data.entities.ApiResponseResult
import com.example.data.util.Mapper
import com.example.domain.entity.Response
import com.example.domain.entity.Result
import javax.inject.Inject

class ApiResponseToResponseMapper @Inject constructor(
    private val mapper: Mapper<ApiResponseResult, Result>
) : Mapper<ApiResponse, Response>() {
    override fun transform(input: ApiResponse) = Response(
        count = input.count,
        next = input.next,
        previous = input.previous,
        results = input.results.let(mapper::transformList)
    )
}