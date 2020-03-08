package com.movilehackafro.data.models

import com.google.gson.annotations.SerializedName

data class AreaResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("sub_areas")
    val subAreas: List<SubAreaResponse>
)