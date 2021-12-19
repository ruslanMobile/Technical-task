package com.example.domain.usecase

import com.example.domain.models.ResultModel
import com.example.domain.models.SearchModel
import com.example.domain.repository.InfoRepository

class GetInfoUseCase(private val infoRepository: InfoRepository) {
    fun execute(param: SearchModel, ):List<ResultModel>{
        return infoRepository.getInfo(param)
    }
}