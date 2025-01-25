package com.example.testtaskintern.domain.entity

data class Information (
    val bin: String,
    val country: String,
    val latitude: Int,
    val longitude: Int,
    val cardType: String,
    val bankName: String,
    val bankUrl: String,
    val bankPhone: String,
    val bankCity: String
)