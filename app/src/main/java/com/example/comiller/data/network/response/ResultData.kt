package com.example.comiller.data.network.response

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class ResultData(
    val data: List<Data>,
    val message: String?,
    val status: Int?
)


@kotlinx.serialization.Serializable
data class Data(
    val title: String?,
    val w1: String?
)