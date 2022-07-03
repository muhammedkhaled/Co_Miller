package com.example.comiller.data.network.response

data class ResultData(
    val data: List<Data>,
    val message: String,
    val status: Int
)

data class Data(
    val title: String,
    val w1: String
)