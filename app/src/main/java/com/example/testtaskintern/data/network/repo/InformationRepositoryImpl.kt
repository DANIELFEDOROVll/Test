package com.example.testtaskintern.data.network.repo

import com.example.testtaskintern.data.network.mapper.DtoToInformationDbMapper
import com.example.testtaskintern.data.network.repo.utils.InternetChecker
import com.example.testtaskintern.data.network.service.InformationService
import com.example.testtaskintern.data.storage.dao.InformationDao
import com.example.testtaskintern.data.storage.entity.InformationDb
import com.example.testtaskintern.data.storage.mapper.InformationDbToDomainMapper
import com.example.testtaskintern.domain.InformationRepository
import com.example.testtaskintern.domain.entity.Information

class InformationRepositoryImpl(
    private val api: InformationService,
    private val dtoToInformationDbMapper: DtoToInformationDbMapper,
    private val informationDbToDomainMapper: InformationDbToDomainMapper,
    private val internetChecker: InternetChecker,
    private val informationDao: InformationDao
): InformationRepository {
    override suspend fun getInformationByBin(bin: String): Information {
        val informationDb: InformationDb
        if(internetChecker.isInternetAvailable()){
            val informationDto = api.getInformation(bin)
            informationDb = dtoToInformationDbMapper(informationDto,
                informationDto.bank,
                informationDto.country,
                bin)

            informationDao.putInformation(informationDb)
        }
        else{
            // нет подключения
        }

        return informationDbToDomainMapper(informationDao.getInformationByBin(bin))
    }

    override suspend fun getInformationHistory(): List<Information> {
        return informationDao.getHistoryInformation().map { informationDbToDomainMapper(it) }
    }

}