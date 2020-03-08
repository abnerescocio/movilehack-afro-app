package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.source.remote.services.CommonService
import com.movilehackafro.domain.models.Area
import com.movilehackafro.domain.models.SubArea
import com.movilehackafro.domain.repositories.AreaRepository

class AreaRepositoryImpl(
    private val commonService: CommonService
): AreaRepository {

    override suspend fun listByDisciplineIds(disciplineIds: List<Long>): List<Area> {
        //return commonService.getAreas(disciplineIds).map { it.toDomain() }
        return listOf(
            Area(1, "T.I.", listOf(
                SubArea(11, 1, "Tecnologia da Informação", ""),
                SubArea(11, 1, "Sistemas de Informação", ""),
                SubArea(11, 1, "Análise e Desenvolvimento de Sistemas", "")
            )),
            Area(2, "Medicina", listOf(
                SubArea(11, 1, "Medicina", ""),
                SubArea(11, 1, "Enfermagem", ""),
                SubArea(11, 1, "Cosmética", "")
            ))
        )
    }

}