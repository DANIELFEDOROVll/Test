package com.example.testtaskintern.domain.usecase


import com.example.testtaskintern.domain.InformationRepository
import com.example.testtaskintern.domain.entity.Information


interface GetInformationUseCase{
    suspend operator fun invoke(bin: String): Information
}

class GetInformationUseCaseImpl(
    private val repo: InformationRepository
): GetInformationUseCase {
    override suspend fun invoke(bin: String): Information {
        return repo.getInformationByBin(bin)
    }
}