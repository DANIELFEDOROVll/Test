package com.example.testtaskintern.DI


import com.example.testtaskintern.data.network.mapper.DtoToInformationDbMapper
import com.example.testtaskintern.data.network.repo.utils.InternetChecker
import com.example.testtaskintern.data.network.service.InformationService
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



private const val BASE_URL = "https://lookup.binlist.net/"

val AppModule = module{
    single { createRetrofit() }
    single { get<Retrofit>().create(InformationService::class.java) }

    single { DtoToInformationDbMapper() }

    single { InternetChecker(androidApplication()) }
}

fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}