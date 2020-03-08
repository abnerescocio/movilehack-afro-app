package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.source.remote.services.SchoolService
import com.movilehackafro.domain.models.Content
import com.movilehackafro.domain.repositories.ContentRepository

class ContentRepositoryImpl(
    private val schoolService: SchoolService
): ContentRepository {

    override suspend fun list(schoolId: Long, disciplineId: Long): List<Content> {
        return schoolService.getContents(schoolId, disciplineId).map { it.toDomain() }
    }

}