package com.example.technicaltask.presentation

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.network.NetworkGetInfoImpl
import com.example.data.repository.InfoRepositoryImpl
import com.example.domain.models.ResultModel
import com.example.domain.models.SearchModel
import com.example.domain.usecase.GetInfoUseCase

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val networkGetInfo by lazy { NetworkGetInfoImpl(application) }
    private val infoRepository by lazy { InfoRepositoryImpl(networkGetInfo) }
    private val getInfoUseCase by lazy { GetInfoUseCase(infoRepository) }

    val resultLiveData:LiveData<List<ResultModel>> = networkGetInfo.resultLiveData

    fun getInfo(text: String){
        val param = SearchModel(text)
        getInfoUseCase.execute(param = param)
    }
}