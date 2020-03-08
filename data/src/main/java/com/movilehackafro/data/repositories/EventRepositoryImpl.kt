package com.movilehackafro.data.repositories

import com.movilehackafro.data.mappers.toDomain
import com.movilehackafro.data.source.remote.services.SchoolService
import com.movilehackafro.domain.models.Event
import com.movilehackafro.domain.models.EventStatus
import com.movilehackafro.domain.repositories.EventRepository
import java.util.*

class EventRepositoryImpl(
    private val schoolService: SchoolService
): EventRepository {

    override suspend fun list(schoolId: Long): List<Event> {
        //return schoolService.getEvents(schoolId).map { it.toDomain() }
        return listOf(
            Event(1, 1, Date(), schoolId, "", EventStatus.CONFIRMED),
            Event(2, 1, Date(), schoolId, "", EventStatus.CONFIRMED)
        )
    }

}