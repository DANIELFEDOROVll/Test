package com.example.testtaskintern.data.network.entity


data class InformationDto (
    val number: NumDto,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: CountryDto,
    val bank: BankDto,
)