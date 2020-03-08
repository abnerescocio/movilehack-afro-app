package com.movilehackafro.domain.models

import java.util.*

data class Event(
    val id: Long,
    val institutionId: Long,
    val date: Date,
    val schoolId: Long,
    val description: String,
    val status: EventStatus
)