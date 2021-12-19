package com.example.domain.repository

import com.example.domain.models.ResultModel
import com.example.domain.models.SearchModel

interface InfoRepository {
    fun getInfo(word: SearchModel): List<ResultModel>
}