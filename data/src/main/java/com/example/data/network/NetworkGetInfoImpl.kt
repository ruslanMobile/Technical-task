package com.example.data.network

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.network.request.RetrofitClient
import com.example.domain.models.ResultModel
import com.example.domain.models.SearchModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkGetInfoImpl(
    context: Context,
) : NetworkGetInfo {

    private val resultMutableLiveData = MutableLiveData<List<ResultModel>>()
    val resultLiveData: LiveData<List<ResultModel>> = resultMutableLiveData

    override fun get(word: SearchModel){
        var call = RetrofitClient.getInstance().getInfo(word.word)
        call?.enqueue(object : Callback<List<ResultModel>> {
            override fun onResponse(
                call: Call<List<ResultModel>>?,
                response: Response<List<ResultModel>>?
            ) {
                if(response?.body() != null)
                resultMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<ResultModel>>?, t: Throwable?) {
                Log.d("MyLog", "onFailure " + t.toString())

            }
        })
    }
}