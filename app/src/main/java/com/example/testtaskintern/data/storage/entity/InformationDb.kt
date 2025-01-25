package com.example.testtaskintern.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtaskintern.data.storage.entity.InformationDb.Companion.INFORMATION_TABLE_NAME

@Entity(tableName = INFORMATION_TABLE_NAME)
data class InformationDb(
    @PrimaryKey
    val bin: String,
    val country: String,
    val latitude: Int,
    val longitude: Int,
    val cardType: String,
    val bankName: String,
    val bankUrl: String,
    val bankPhone: String,
    val bankCity: String
)
{
    companion object{
        const val INFORMATION_TABLE_NAME = "information_db"
    }
}