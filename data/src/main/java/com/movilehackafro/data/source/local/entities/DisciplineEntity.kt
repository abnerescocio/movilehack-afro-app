package com.movilehackafro.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DisciplineEntity(
    @PrimaryKey
    val id: Long?,
    val name: String?
)