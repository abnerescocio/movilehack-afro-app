package com.movilehackafro.domain.repositories

import com.movilehackafro.domain.models.Content

interface ContentRepository {

    suspend fun list(schoolId: Long, disciplineId: Long): List<Content>

}