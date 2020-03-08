package com.movilehackafro.data.mappers

import com.movilehackafro.data.source.remote.responses.EventResponse
import com.movilehackafro.domain.models.Event
import com.movilehackafro.domain.models.EventStatus

fun EventResponse.toDomain() = Event(
    id = this.id,
    institutionId = this.institutionId,
    date = this.date,
    schoolId = this.schoolId,
    description = this.description,
    status = EventStatus.valueOf(this.status)
)