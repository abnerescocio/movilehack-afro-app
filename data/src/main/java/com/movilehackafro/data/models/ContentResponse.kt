package com.movilehackafro.data.models

import com.google.gson.annotations.SerializedName

data class ContentResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("discipline_id")
    val disciplineId: Long,
    @SerializedName("url")
    val url: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String
)