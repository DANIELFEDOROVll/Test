package com.example.testtaskintern.data.network.service

import com.example.testtaskintern.data.network.entity.InformationDto
import retrofit2.http.GET
import retrofit2.http.Path

interface InformationService{
    @GET("{bin}")
    suspend fun getInformation(@Path("bin") bin: String): InformationDto
}