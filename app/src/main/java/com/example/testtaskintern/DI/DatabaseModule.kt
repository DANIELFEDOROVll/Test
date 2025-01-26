package com.example.testtaskintern.DI

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.testtaskintern.data.storage.dao.InformationDao
import com.example.testtaskintern.data.storage.database.AppDatabase
import com.example.testtaskintern.data.storage.database.AppDatabase.Companion.DATABASE_NAME
import com.example.testtaskintern.data.storage.datasource.LocalDataSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { getHistoryDatabase(androidApplication()) }

    single { getInformationDao(get()) }
    single { LocalDataSourceImpl(get()) }
}

fun getHistoryDatabase(context: Context): AppDatabase{
    return databaseBuilder(
        context,
        AppDatabase::class.java, DATABASE_NAME
    ).build()
}

fun getInformationDao(db: AppDatabase): InformationDao = db.getInformationDao()