package com.example.testtaskintern.data.storage.mapper

import com.example.testtaskintern.data.storage.entity.InformationDb
import com.example.testtaskintern.domain.entity.Information

class InformationDbToDomainMapper: (InformationDb) -> Information {
    override fun invoke(informationDb: InformationDb): Information {
        return with(informationDb){
            Information(
                bin = bin,
                country = country,
                latitude = latitude,
                longitude = longitude,
                cardType = cardType,
                bankName = bankName,
                bankUrl = bankUrl,
                bankPhone = bankPhone,
                bankCity = bankCity,
            )
        }
    }
}