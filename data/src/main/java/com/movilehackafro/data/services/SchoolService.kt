package com.movilehackafro.data.services

import com.movilehackafro.data.models.ContentResponse
import retrofit2.http.Query

interface SchoolService {

    suspend fun getContents(
        @Query("school_id")
        schoolId: Long,
        @Query("discipline_id")
        disciplineId: Long
    ): List<ContentResponse>

}