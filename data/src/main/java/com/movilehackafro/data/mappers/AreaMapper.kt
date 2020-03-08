package com.movilehackafro.data.mappers

import com.movilehackafro.data.source.remote.responses.AreaResponse
import com.movilehackafro.domain.models.Area

fun AreaResponse.toDomain() = Area(
    id = this.id,
    name = this.name,
    description = this.description,
    subAreas = this.subAreas.map { it.toDomain() }
)