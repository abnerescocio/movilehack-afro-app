package com.movilehackafro.domain.models

data class Content(
    val id: Long,
    val disciplineId: Long,
    val url: String,
    val title: String,
    val description: String
)