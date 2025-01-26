package com.example.testtaskintern.presentation.gettingdata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskintern.core.exeptions.NoInternetAndNoDbData
import com.example.testtaskintern.domain.usecase.GetInformationUseCase
import com.example.testtaskintern.presentation.mapper.InformationToUiMapper
import com.example.testtaskintern.presentation.model.InformationItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GettingDataViewModel(
    private val getInformationUseCase: GetInformationUseCase,
    private val informationToUiMapper: InformationToUiMapper,
): ViewModel() {

    private val _information = MutableStateFlow<InformationItem?>(null)
    val information: StateFlow<InformationItem?> get() = _information



    fun loadInformation(bin: String){
        viewModelScope.launch {
            try {
                _information.value = informationToUiMapper(getInformationUseCase(bin))
            }
            catch (_: NoInternetAndNoDbData){

            }
        }
    }
}





