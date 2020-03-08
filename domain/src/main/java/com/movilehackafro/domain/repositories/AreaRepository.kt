package com.movilehackafro.domain.repositories

import com.movilehackafro.domain.models.Area

interface AreaRepository {

    suspend fun listByDisciplineIds(disciplineIds: List<Long>): List<Area>

}