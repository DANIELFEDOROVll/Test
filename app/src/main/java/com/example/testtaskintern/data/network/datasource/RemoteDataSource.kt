package com.example.testtaskintern.data.network.datasource

import com.example.testtaskintern.data.network.entity.InformationDto

interface RemoteDataSource {
    suspend fun getInformationByBin(bin: String): InformationDto
}