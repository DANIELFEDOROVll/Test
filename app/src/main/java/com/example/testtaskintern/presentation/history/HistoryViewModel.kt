package com.example.testtaskintern.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskintern.domain.usecase.GetHistoryUseCase
import com.example.testtaskintern.presentation.mapper.InformationToUiMapper
import com.example.testtaskintern.presentation.model.InformationItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val getHistoryUseCase: GetHistoryUseCase,
    private val informationToUiMapper: InformationToUiMapper,
): ViewModel() {
    private val _history = MutableStateFlow<List<InformationItem>>(emptyList())
    val history: StateFlow<List<InformationItem>> get() = _history

    init {
        getHistory()
    }

    private fun getHistory(){
        viewModelScope.launch {
            _history.value = getHistoryUseCase().map{ informationToUiMapper(it) }
        }
    }
}