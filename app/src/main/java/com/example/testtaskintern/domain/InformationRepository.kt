package com.example.testtaskintern.domain

import com.example.testtaskintern.domain.entity.Information

interface InformationRepository {
    suspend fun getInformationByBin(bin: String): Information

    suspend fun getInformationHistory(): List<Information>
}