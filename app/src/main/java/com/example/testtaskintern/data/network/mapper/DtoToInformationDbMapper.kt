package com.example.testtaskintern.data.network.mapper

import com.example.testtaskintern.data.network.entity.BankDto
import com.example.testtaskintern.data.network.entity.CountryDto
import com.example.testtaskintern.data.network.entity.InformationDto
import com.example.testtaskintern.data.storage.entity.InformationDb

class DtoToInformationDbMapper {
    operator fun invoke(
        informationDto: InformationDto?,
        bankDto: BankDto?,
        countryDto: CountryDto?,
        bin: String
    ): InformationDb {
        return InformationDb(
            bin = bin,
            country = countryDto?.name ?: DEFAULT_STRING_VALUE,
            latitude = countryDto?.latitude ?: DEFAULT_INT_VALUE,
            longitude = countryDto?.longitude ?: DEFAULT_INT_VALUE,
            cardType = informationDto?.type ?: DEFAULT_STRING_VALUE,
            bankName = bankDto?.name ?: DEFAULT_STRING_VALUE,
            bankUrl = bankDto?.url ?: DEFAULT_STRING_VALUE,
            bankPhone = bankDto?.phone ?: DEFAULT_STRING_VALUE,
            bankCity = bankDto?.city ?:DEFAULT_STRING_VALUE,
        )
    }
    companion object{
        private const val DEFAULT_STRING_VALUE = "no value"
        private const val DEFAULT_INT_VALUE = -1
    }
}