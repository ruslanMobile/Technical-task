package com.example.data.repository

import android.content.Context
import android.util.Log
import com.example.data.network.NetworkGetInfo
import com.example.domain.models.ResultModel
import com.example.domain.models.SearchModel
import com.example.domain.repository.InfoRepository

class InfoRepositoryImpl(private val networkGetInfo: NetworkGetInfo):InfoRepository {
    override fun getInfo(word: SearchModel){
        networkGetInfo.get(word)
    }
}