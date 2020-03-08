package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.services.CommonService
import com.movilehackafro.domain.models.Discipline
import com.movilehackafro.domain.repositories.DisciplineRepository

class DisciplineRepositoryImpl(
    private val commonService: CommonService
): DisciplineRepository {

    override suspend fun list(): List<Discipline> {
        return commonService.getDisciplines().map { it.toDomain() }
    }

}