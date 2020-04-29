package com.example.data.mappers

import com.example.data.entities.ApiHeldItem
import com.example.data.entities.ApiItemUrl
import com.example.data.entities.ApiVersionDetail
import com.example.data.util.Mapper
import com.example.domain.entity.HeldItem
import com.example.domain.entity.ItemUrl
import com.example.domain.entity.VersionDetail
import javax.inject.Inject

class ApiHeldItemToHeldItemMapper @Inject constructor(
    private val mapperItem: Mapper<ApiItemUrl, ItemUrl>,
    private val mapperVersionDetail: Mapper<ApiVersionDetail, VersionDetail>
) : Mapper<ApiHeldItem, HeldItem>() {
    override fun transform(input: ApiHeldItem) = HeldItem(
        item = input.item?.let(mapperItem::transform),
        versionDetails = input.versionDetails.let(mapperVersionDetail::transformList)
    )

}