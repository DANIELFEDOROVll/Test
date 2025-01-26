package com.example.testtaskintern.data.repository

import com.example.testtaskintern.data.network.datasource.RemoteDataSource
import com.example.testtaskintern.data.network.mapper.DtoToInformationDbMapper
import com.example.testtaskintern.core.utils.InternetChecker
import com.example.testtaskintern.core.exeptions.NoInternetAndNoDbData
import com.example.testtaskintern.data.storage.datasource.LocalDataSource
import com.example.testtaskintern.data.storage.entity.InformationDb
import com.example.testtaskintern.data.storage.mapper.InformationDbToDomainMapper
import com.example.testtaskintern.domain.InformationRepository
import com.example.testtaskintern.domain.entity.Information

class InformationRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val dtoToInformationDbMapper: DtoToInformationDbMapper,
    private val informationDbToDomainMapper: InformationDbToDomainMapper,
    private val internetChecker: InternetChecker,
): InformationRepository {

    override suspend fun getInformationByBin(bin: String): Information {
        val informationDb: InformationDb?
        if(internetChecker.isInternetAvailable()){
            val informationDto = remoteDataSource.getInformationByBin(bin)
            informationDb = dtoToInformationDbMapper(informationDto,
                informationDto.bank,
                informationDto.country,
                bin)

            localDataSource.putInformationDb(informationDb)
        }
        else{
            informationDb = localDataSource.getInformationByBin(bin)
            if(informationDb == null) throw NoInternetAndNoDbData()
        }

        return informationDbToDomainMapper(informationDb)
    }

    override suspend fun getInformationHistory(): List<Information> {
        return localDataSource.getHistoryInformation().map { informationDbToDomainMapper(it) }
    }

}