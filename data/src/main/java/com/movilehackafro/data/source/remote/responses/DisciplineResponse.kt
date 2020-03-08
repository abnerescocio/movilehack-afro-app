package com.movilehackafro.data.source.remote.responses

import com.google.gson.annotations.SerializedName

data class DisciplineResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("string")
    val name: String
)