package com.example.domain.models

import com.sun.xml.internal.ws.developer.Serialization
import java.io.Serializable

@Serialization
data class ResultModel(
    val word: String,
    val phonetic: String,
    val meanings: List<MeaningModel>
)
