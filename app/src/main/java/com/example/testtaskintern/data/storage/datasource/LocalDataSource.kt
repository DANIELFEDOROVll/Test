package com.example.testtaskintern.data.storage.datasource

import com.example.testtaskintern.data.storage.entity.InformationDb

interface LocalDataSource {
    suspend fun getInformationByBin(bin: String): InformationDb?

    suspend fun getHistoryInformation(): List<InformationDb>

    suspend fun putInformationDb(information: InformationDb)
}