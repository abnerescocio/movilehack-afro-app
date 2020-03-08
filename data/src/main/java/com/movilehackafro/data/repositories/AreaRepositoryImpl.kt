package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.services.CommonService
import com.movilehackafro.domain.models.Area
import com.movilehackafro.domain.repositories.AreaRepository

class AreaRepositoryImpl(
    private val commonService: CommonService
): AreaRepository {

    override suspend fun listByDisciplineIds(disciplineIds: List<Long>): List<Area> {
        return commonService.getAreas(disciplineIds).map { it.toDomain() }
    }

}