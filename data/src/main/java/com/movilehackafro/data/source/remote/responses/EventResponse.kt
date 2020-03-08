package com.movilehackafro.data.source.remote.responses

import java.util.*

data class EventResponse(
    val id: Long,
    val institutionId: Long,
    val date: Date,
    val schoolId: Long,
    val status: String
)