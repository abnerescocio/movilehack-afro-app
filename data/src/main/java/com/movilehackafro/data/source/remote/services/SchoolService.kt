package com.movilehackafro.data.source.remote.services

import com.movilehackafro.data.source.remote.responses.ContentResponse
import com.movilehackafro.data.source.remote.responses.EventResponse
import retrofit2.http.Query

interface SchoolService {

    suspend fun getContents(
        @Query("school_id")
        schoolId: Long,
        @Query("discipline_id")
        disciplineId: Long
    ): List<ContentResponse>

    suspend fun getEvents(
        @Query("school_id")
        schoolId: Long
    ): List<EventResponse>

}