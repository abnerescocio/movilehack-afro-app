package com.movilehackafro.domain.repositories

import com.movilehackafro.domain.models.Area

interface AreaRepository {

    suspend fun listByDisciplineId(disciplineId: Long): List<Area>

}