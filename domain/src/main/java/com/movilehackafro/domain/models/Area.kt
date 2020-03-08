package com.movilehackafro.domain.models

data class Area(
    val id: Long,
    val name: String,
    val description: String,
    val subAreas: List<SubArea>
)