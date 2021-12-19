package com.example.data.network.request

import com.example.data.network.utils.Api
import com.example.data.network.utils.Credentials
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance: Api? = null

    @Synchronized
    fun getInstance(): Api {
        if (instance == null)
            instance = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Credentials.BASE_URL)
                .build()
                .create(Api::class.java)
        return instance as Api
    }
}