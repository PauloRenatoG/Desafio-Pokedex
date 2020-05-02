package com.example.data.mappers

import com.example.data.entities.ApiHeldItem
import com.example.data.entities.ApiHeldItems
import com.example.data.util.Mapper
import com.example.domain.entity.HeldItem
import com.example.domain.entity.HeldItems
import javax.inject.Inject

class ApiHeldItemsToHeldItemsMapper @Inject constructor(
    private val mapper: Mapper<ApiHeldItem, HeldItem>
) : Mapper<ApiHeldItems, HeldItems>() {
    override fun transform(input: ApiHeldItems) = HeldItems(
        heldItems = input.heldItems.let(mapper::transformList)
    )

}