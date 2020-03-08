package com.movilehackafro.data.mappers

import com.movilehackafro.data.source.remote.responses.SubAreaResponse
import com.movilehackafro.domain.models.SubArea

fun SubAreaResponse.toDomain() = SubArea(
    id = this.id,
    areaId = this.areaIds,
    description = this.description,
    name = this.name
)