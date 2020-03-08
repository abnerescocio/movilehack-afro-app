package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.source.remote.services.SchoolService
import com.movilehackafro.domain.models.Event
import com.movilehackafro.domain.repositories.EventRepository

class EventRepositoryImpl(
    private val schoolService: SchoolService
): EventRepository {

    override suspend fun list(schoolId: Long): List<Event> {
        return schoolService.getEvents(schoolId).map { it.toDomain() }
    }

}