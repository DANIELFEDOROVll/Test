package com.example.testtaskintern.domain.usecase

import com.example.testtaskintern.domain.InformationRepository
import com.example.testtaskintern.domain.entity.Information

interface GetHistoryUseCase {
    suspend operator fun invoke(): List<Information>
}

class GetHistoryUseCaseImpl(
    private val repository: InformationRepository
): GetHistoryUseCase{
    override suspend fun invoke(): List<Information> {
        return repository.getInformationHistory()
    }

}