package com.movilehackafro.domain.repositories

import com.movilehackafro.domain.models.Event

interface EventRepository {

    suspend fun list(schoolId: Long): List<Event>

}