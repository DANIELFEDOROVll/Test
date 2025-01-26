package com.example.testtaskintern.DI

import com.example.testtaskintern.domain.usecase.GetHistoryUseCaseImpl
import com.example.testtaskintern.domain.usecase.GetInformationUseCase
import com.example.testtaskintern.domain.usecase.GetInformationUseCaseImpl
import com.example.testtaskintern.presentation.gettingdata.GettingDataViewModel
import com.example.testtaskintern.presentation.history.HistoryViewModel
import com.example.testtaskintern.presentation.mapper.InformationToUiMapper
import org.koin.dsl.module

val viewModelModule = module {
    single { GettingDataViewModel(get(), get()) }
    single { HistoryViewModel(get(), get()) }

    single { GetInformationUseCaseImpl(get()) }
    single { GetHistoryUseCaseImpl(get()) }

    single { InformationToUiMapper() }
}