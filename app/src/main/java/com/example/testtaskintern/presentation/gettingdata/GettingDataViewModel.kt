package com.example.testtaskintern.presentation.gettingdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() =_message


    fun loadInformation(bin: String){
        if(bin == "") _message.value = "Введите значение"
        else {
            viewModelScope.launch {
                try {
                    _information.value = informationToUiMapper(getInformationUseCase(bin))
                } catch (e: NoInternetAndNoDbData) {
                    _message.value = "No internet and no data"
                } catch (e: Exception) {
                    _message.value = "To many requests or other exception"
                }
            }
        }
    }
}





