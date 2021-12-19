package com.example.domain.models

import com.sun.xml.internal.ws.developer.Serialization

@Serialization
data class MeaningModel(
    val partOfSpeech: String,
    val definition: String
)
