package com.example.data.network.utils

import com.example.domain.models.ResultModel
import com.example.domain.models.SearchModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("{word}")
    fun getInfo(@Path("word") searchModel: String) : Call<List<ResultModel>>
}