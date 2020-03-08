package com.movilehackafro.data.source.remote.responses

import com.google.gson.annotations.SerializedName

data class AreaResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("sub_areas")
    val subAreas: List<SubAreaResponse>
)