package com.movilehackafro.data.mappers

import com.movilehackafro.data.models.DisciplineResponse
import com.movilehackafro.domain.models.Discipline

fun DisciplineResponse.toDomain() = Discipline(
    id = this.id,
    name = this.name
)