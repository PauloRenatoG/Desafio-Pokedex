package com.example.data.mappers

import com.example.data.entities.ApiEffectEntry
import com.example.data.util.Mapper
import com.example.domain.entity.EffectEntry
import javax.inject.Inject

class ApiEffectEntryToEffectEntryMapper @Inject constructor(

) : Mapper<ApiEffectEntry, EffectEntry>() {
    override fun transform(input: ApiEffectEntry) = EffectEntry(
        effect = input.effect,
        shortEffect = input.shortEffect
    )

}