package com.example.desafiopokedex.graph.module

import com.example.data.entities.*
import com.example.data.mappers.*
import com.example.data.util.Mapper
import com.example.domain.entity.*
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

    @Binds
    fun bindsApiPokemonDetailToSpritesMapper(
        mapper: ApiPokemonDetailToSpritesMapper
    ): Mapper<ApiPokemonDetail, Sprites>

    @Binds
    fun bindsApiPokemonDetailToPokemonDetailMapper(
        mapper: ApiPokemonDetailToPokemonDetailMapper
    ): Mapper<ApiPokemonDetail, PokemonDetail>

    @Binds
    fun bindsApiAbilityToAbilityMapper(
        mapper: ApiAbilityToAbilityMapper
    ): Mapper<ApiAbility, Ability>

    @Binds
    fun bindsApiAbilityUrlToAbilityUrlMapper(
        mapper: ApiAbilityUrlToAbilityUrlMapper
    ): Mapper<ApiAbilityUrl, AbilityUrl>

    @Binds
    fun bindsApiFormUrlToFormUrlMapper(
        mapper: ApiFormUrlToFormUrlMapper
    ): Mapper<ApiFormUrl, FormUrl>

    @Binds
    fun bindsApiGameIndiceToGameIndiceMapper(
        mapper: ApiGameIndiceToGameIndiceMapper
    ): Mapper<ApiGameIndice, GameIndice>

    @Binds
    fun bindsApiVersionUrlToVersionUrlMapper(
        mapper: ApiVersionUrlToVersionUrlMapper
    ): Mapper<ApiVersionUrl, VersionUrl>

    @Binds
    fun bindsApiHeldItemsToHeldItemsMapper(
        mapper: ApiHeldItemsToHeldItemsMapper
    ): Mapper<ApiHeldItems, HeldItems>

    @Binds
    fun bindsApiHeldItemToHeldItemMapper(
        mapper: ApiHeldItemToHeldItemMapper
    ): Mapper<ApiHeldItem, HeldItem>

    @Binds
    fun bindsApiItemUrlToItemUrlMapper(
        mapper: ApiItemUrlToItemUrlMapper
    ): Mapper<ApiItemUrl, ItemUrl>

    @Binds
    fun bindsApiVersionDetailToVersionDetailMapper(
        mapper: ApiVersionDetailToVersionDetailMapper
    ): Mapper<ApiVersionDetail, VersionDetail>

    @Binds
    fun bindsApiMoveToMoveMapper(
        mapper: ApiMoveToMoveMapper
    ): Mapper<ApiMove, Move>

    @Binds
    fun bindsApiVersionGroupDetailToVersionGroupDetailMapper(
        mapper: ApiVersionGroupDetailToVersionGroupDetailMapper
    ): Mapper<ApiVersionGroupDetail, VersionGroupDetail>

    @Binds
    fun bindsApiMoveUrlToMoveUrlMapper(
        mapper: ApiMoveUrlToMoveUrlMapper
    ): Mapper<ApiMoveUrl, MoveUrl>

    @Binds
    fun bindsApiMoveLearnMethodUrlToMoveLearnMethodUrlMapper(
        mapper: ApiMoveLearnMethodUrlToMoveLearnMethodUrlMapper
    ): Mapper<ApiMoveLearnMethodUrl, MoveLearnMethodUrl>

    @Binds
    fun bindsApiVersionGroupUrlToVersionGroupUrlMapper(
        mapper: ApiVersionGroupUrlToVersionGroupUrlMapper
    ): Mapper<ApiVersionGroupUrl, VersionGroupUrl>

    @Binds
    fun bindsApiSpeciesUrlToSpeciesUrlMapper(
        mapper: ApiSpeciesUrlToSpeciesUrlMapper
    ): Mapper<ApiSpeciesUrl, SpeciesUrl>

    @Binds
    fun bindsApiStatToStatMapper(
        mapper: ApiStatToStatMapper
    ): Mapper<ApiStat, Stat>

    @Binds
    fun bindsApiStatUrlToStatUrlMapper(
        mapper: ApiStatUrlToStatUrlMapper
    ): Mapper<ApiStatUrl, StatUrl>

    @Binds
    fun bindsApiTypeToTypeMapper(
        mapper: ApiTypeToTypeMapper
    ): Mapper<ApiType, Type>

    @Binds
    fun bindsApiTypeUrlToTypeUrlMapper(
        mapper: ApiTypeUrlToTypeUrlMapper
    ): Mapper<ApiTypeUrl, TypeUrl>
}