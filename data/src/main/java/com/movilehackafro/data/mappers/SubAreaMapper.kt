package com.movilehackafro.data.mappers

import com.movilehackafro.data.models.SubAreaResponse
import com.movilehackafro.domain.models.SubArea

fun SubAreaResponse.toDomain() = SubArea(
    id = this.id,
    areaIds = this.areaIds,
    name = this.name
)