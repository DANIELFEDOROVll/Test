package com.example.testtaskintern.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtaskintern.data.storage.dao.InformationDao
import com.example.testtaskintern.data.storage.entity.InformationDb

@Database(
    entities = [InformationDb::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getInformationDao(): InformationDao

    companion object{
        const val DATABASE_NAME = "history_database"
    }
}