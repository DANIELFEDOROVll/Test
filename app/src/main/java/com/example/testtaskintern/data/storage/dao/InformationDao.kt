package com.example.testtaskintern.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testtaskintern.data.storage.entity.InformationDb

@Dao
interface InformationDao {
    @Insert
    suspend fun putInformation(information: InformationDb)

    @Query("SELECT * FROM information_db ")
    suspend fun getHistoryInformation(): List<InformationDb>

    @Query("SELECT * FROM information_db WHERE bin = :bin")
    suspend fun getInformationByBin(bin: String): InformationDb
}