package com.example.testtaskintern.DI


import com.example.testtaskintern.data.network.mapper.DtoToInformationDbMapper
import com.example.testtaskintern.core.utils.InternetChecker
import com.example.testtaskintern.data.network.datasource.RemoteDataSourceImpl
import com.example.testtaskintern.data.network.service.InformationService
import com.example.testtaskintern.data.repository.InformationRepositoryImpl
import com.example.testtaskintern.data.storage.mapper.InformationDbToDomainMapper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



private const val BASE_URL = "https://lookup.binlist.net/"

val appModule = module{
    single{ InformationRepositoryImpl(
        localDataSource = get(),
        remoteDataSource = get(),
        dtoToInformationDbMapper = get(),
        informationDbToDomainMapper = get(),
        internetChecker = get(),
    ) }

    single { InternetChecker(androidApplication()) }

    single { createRetrofit() }
    single { get<Retrofit>().create(InformationService::class.java) }

    single { DtoToInformationDbMapper() }
    single { InformationDbToDomainMapper() }

    single { InternetChecker(androidApplication()) }
    single { RemoteDataSourceImpl(get()) }
}

fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}