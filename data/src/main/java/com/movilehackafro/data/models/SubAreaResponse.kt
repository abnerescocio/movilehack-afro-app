package com.movilehackafro.data.models

import com.google.gson.annotations.SerializedName

data class SubAreaResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("areas_id")
    val areaIds: Long,
    @SerializedName("name")
    val name: String
)