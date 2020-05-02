package com.example.data.mappers

import com.example.data.entities.ApiResponseResult
import com.example.data.util.Mapper
import com.example.domain.entity.Result
import javax.inject.Inject

class ApiResponseResultToResult @Inject constructor(

) : Mapper<ApiResponseResult, Result>() {
    override fun transform(input: ApiResponseResult) = Result(
        name = input.name,
        url = input.url
    )

}