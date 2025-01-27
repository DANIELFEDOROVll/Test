package com.example.testtaskintern.presentation.mapper

import com.example.testtaskintern.domain.entity.Information
import com.example.testtaskintern.presentation.model.InformationItem

class InformationToUiMapper: (Information) -> InformationItem {
    override fun invoke(information: Information): InformationItem {
        return with(information){
            InformationItem(
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