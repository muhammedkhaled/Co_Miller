package com.example.comiller.data.network.interfaces

import com.example.comiller.data.network.response.*
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeApi {

    @POST("prog1")
    suspend fun program1(
        @Body program1: Program1
    ) : ResultData

    @POST("prog2")
    suspend fun program2(
        @Body program2: Program2
    ) : ResultData

    @POST("prog3")
    suspend fun program3(
        @Body program3: Program3
    ) : ResultData

}
