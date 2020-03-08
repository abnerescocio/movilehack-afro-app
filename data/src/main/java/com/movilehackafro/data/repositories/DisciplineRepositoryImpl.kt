package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.mappers.toEntity
import com.movilehackafro.data.source.local.daos.DisciplineDao
import com.movilehackafro.data.source.remote.services.CommonService
import com.movilehackafro.domain.models.Discipline
import com.movilehackafro.domain.repositories.DisciplineRepository

class DisciplineRepositoryImpl(
    private val commonService: CommonService,
    private val disciplineDao: DisciplineDao
): DisciplineRepository {

    override suspend fun set(disciplines: List<Discipline>) {
        return disciplineDao.set(disciplines.map { it.toEntity() })
    }

    override suspend fun list(): List<Discipline> {
        return commonService.getDisciplines().map { it.toDomain() }
    }

}