package com.movilehackafro.data.source.remote.services

import com.movilehackafro.data.source.remote.responses.AreaResponse
import com.movilehackafro.data.source.remote.responses.DisciplineResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CommonService {

    @GET("areas")
    suspend fun getAreas(@Query("discipline_ids") disciplineIds: List<Long>): List<AreaResponse>

    @GET("disciplines")
    suspend fun getDisciplines(): List<DisciplineResponse>

}