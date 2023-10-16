package com.example.mycars.models

data class CarsData(
    val Count: Int,
    val Message: String,
    val Results: List<Result>,
    val SearchCriteria: Any
)