package com.example.testtaskintern.data.network.datasource

import com.example.testtaskintern.data.network.entity.InformationDto
import com.example.testtaskintern.data.network.service.InformationService

class RemoteDataSourceImpl(
    private val api: InformationService
): RemoteDataSource {
    override suspend fun getInformationByBin(bin: String): InformationDto {
        return api.getInformation(bin)
    }
}