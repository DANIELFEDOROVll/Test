package com.example.testtaskintern.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtaskintern.data.storage.entity.InformationDb

@Dao
interface InformationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun putInformation(information: InformationDb)

    @Query("SELECT * FROM information_db ")
    suspend fun getHistoryInformation(): List<InformationDb>

    @Query("SELECT * FROM information_db WHERE bin = :bin LIMIT 1")
    suspend fun getInformationByBin(bin: String): InformationDb?
}