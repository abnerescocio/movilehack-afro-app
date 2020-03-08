package com.movilehackafro.data.mappers

import com.movilehackafro.data.source.remote.responses.ContentResponse
import com.movilehackafro.domain.models.Content

fun ContentResponse.toDomain() = Content(
    id = this.id,
    disciplineId = this.disciplineId,
    url = this.url,
    title = this.title,
    description = this.description
)