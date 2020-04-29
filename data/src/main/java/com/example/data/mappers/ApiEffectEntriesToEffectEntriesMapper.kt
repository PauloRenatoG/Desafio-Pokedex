package com.example.data.mappers

import com.example.data.entities.ApiEffectEntries
import com.example.data.entities.ApiEffectEntry
import com.example.data.util.Mapper
import com.example.domain.entity.EffectEntries
import com.example.domain.entity.EffectEntry
import javax.inject.Inject

class ApiEffectEntriesToEffectEntriesMapper @Inject constructor(
    private val mapper: Mapper<ApiEffectEntry, EffectEntry>
) : Mapper<ApiEffectEntries, EffectEntries>() {
    override fun transform(input: ApiEffectEntries) = EffectEntries(
        effectEntries = input.effectEntries.let(mapper::transformList)
    )

}