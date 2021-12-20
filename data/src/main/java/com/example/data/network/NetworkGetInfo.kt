package com.example.data.network

import com.example.domain.models.ResultModel
import com.example.domain.models.SearchModel

interface NetworkGetInfo {
    fun get(word: SearchModel)
}