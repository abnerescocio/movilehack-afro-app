package com.movilehackafro.domain.models

data class School(
    val id: Long,
    val name: String,
    val inepMec: Long,
    val cep: String,
    val street: String,
    val number: String,
    val district: String,
    val city: String,
    val state: String,
    val complement: String
)