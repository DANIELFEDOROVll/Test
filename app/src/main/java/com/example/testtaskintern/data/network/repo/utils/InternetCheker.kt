package com.example.testtaskintern.data.network.repo.utils

import android.content.Context
import android.net.ConnectivityManager

class InternetChecker(
    private val context: Context
) {
    fun isInternetAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}