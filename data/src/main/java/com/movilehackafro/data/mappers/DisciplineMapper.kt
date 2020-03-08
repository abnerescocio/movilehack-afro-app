package com.movilehackafro.data.mappers

import com.movilehackafro.data.source.local.entities.DisciplineEntity
import com.movilehackafro.data.source.remote.responses.DisciplineResponse
import com.movilehackafro.domain.models.Discipline

fun DisciplineResponse.toDomain() = Discipline(
    id = this.id,
    name = this.name
)

fun Discipline.toEntity() = DisciplineEntity(
    id = this.id,
    name = this.name
)