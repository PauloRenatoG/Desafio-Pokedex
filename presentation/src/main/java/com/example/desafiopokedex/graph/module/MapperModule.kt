package com.example.desafiopokedex.graph.module

import com.example.data.entities.ApiResponse
import com.example.data.entities.ApiResponseResult
import com.example.data.mappers.ApiResponseResultToResult
import com.example.data.mappers.ApiResponseToResponseMapper
import com.example.data.util.Mapper
import com.example.domain.entity.Response
import com.example.domain.entity.Result
import dagger.Binds
import dagger.Module

@Module
interface MapperModule {

    @Binds
    fun bindsApiResponseResultToResult(
        mapper: ApiResponseResultToResult
    ): Mapper<ApiResponseResult, Result>

    @Binds
    fun bindsApiResponseToResponseMapper(
        mapper: ApiResponseToResponseMapper
    ): Mapper<ApiResponse, Response>
}