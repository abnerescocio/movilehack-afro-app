package com.movilehackafro.domain.repositories

import com.movilehackafro.domain.models.Discipline

interface DisciplineRepository {

    suspend fun list(): List<Discipline>

    suspend fun set(disciplines: List<Discipline>)

}