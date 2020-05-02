package com.example.data.mappers

import com.example.data.entities.ApiAbility
import com.example.data.entities.ApiAbilityUrl
import com.example.data.util.Mapper
import com.example.domain.entity.Ability
import com.example.domain.entity.AbilityUrl
import javax.inject.Inject

class ApiAbilityToAbilityMapper @Inject constructor(
    private val mapper: Mapper<ApiAbilityUrl, AbilityUrl>
) : Mapper<ApiAbility, Ability>() {
    override fun transform(input: ApiAbility) = Ability(
        ability = input.ability?.let(mapper::transform),
        isHidden = input.isHidden,
        slot = input.slot
    )

}