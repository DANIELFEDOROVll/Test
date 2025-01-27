package com.example.testtaskintern.DI

import com.example.testtaskintern.domain.usecase.GetHistoryUseCase
import com.example.testtaskintern.domain.usecase.GetHistoryUseCaseImpl
import com.example.testtaskintern.domain.usecase.GetInformationUseCase
import com.example.testtaskintern.domain.usecase.GetInformationUseCaseImpl
import com.example.testtaskintern.presentation.gettingdata.GettingDataViewModel
import com.example.testtaskintern.presentation.history.HistoryViewModel
import com.example.testtaskintern.presentation.mapper.InformationToUiMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GettingDataViewModel(get(), get()) }
    viewModel { HistoryViewModel(get(), get()) }

    single<GetInformationUseCase> { GetInformationUseCaseImpl(get()) }
    single<GetHistoryUseCase> { GetHistoryUseCaseImpl(get()) }

    single<InformationToUiMapper> { InformationToUiMapper() }
}