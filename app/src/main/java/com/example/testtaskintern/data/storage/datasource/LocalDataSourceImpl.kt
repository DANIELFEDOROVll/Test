package com.example.testtaskintern.data.storage.datasource

import com.example.testtaskintern.data.storage.dao.InformationDao
import com.example.testtaskintern.data.storage.entity.InformationDb

class LocalDataSourceImpl(
    private val informationDao: InformationDao
): LocalDataSource {
    override suspend fun getInformationByBin(bin: String): InformationDb? {
        return informationDao.getInformationByBin(bin)
    }

    override suspend fun getHistoryInformation(): List<InformationDb> {
        return informationDao.getHistoryInformation()
    }

    override suspend fun putInformationDb(information: InformationDb) {
        return informationDao.putInformation(information)
    }
}