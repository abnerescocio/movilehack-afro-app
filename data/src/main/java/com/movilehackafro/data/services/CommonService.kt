package com.movilehackafro.data.services

import com.movilehackafro.data.models.AreaResponse
import com.movilehackafro.data.models.DisciplineResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CommonService {

    @GET("areas")
    suspend fun getAreas(@Query("discipline_ids") disciplineIds: List<Long>): List<AreaResponse>

    @GET("disciplines")
    suspend fun getDisciplines(): List<DisciplineResponse>

}