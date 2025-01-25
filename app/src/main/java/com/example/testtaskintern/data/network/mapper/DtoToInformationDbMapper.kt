package com.example.testtaskintern.data.network.mapper

import com.example.testtaskintern.data.network.entity.BankDto
import com.example.testtaskintern.data.network.entity.CountryDto
import com.example.testtaskintern.data.network.entity.InformationDto
import com.example.testtaskintern.data.storage.entity.InformationDb

class DtoToInformationDbMapper {
    operator fun invoke(
        informationDto: InformationDto,
        bankDto: BankDto,
        countryDto: CountryDto,
        bin: String
    ): InformationDb {
        return InformationDb(
            bin = bin,
            country = countryDto.name,
            latitude = countryDto.latitude,
            longitude = countryDto.longitude,
            cardType = informationDto.type,
            bankName = bankDto.name,
            bankUrl = bankDto.url,
            bankPhone = bankDto.phone,
            bankCity = bankDto.city,
        )
    }
}