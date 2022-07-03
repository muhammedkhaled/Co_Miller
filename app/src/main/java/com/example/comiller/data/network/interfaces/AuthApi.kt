package com.example.comiller.data.network.interfaces

import com.example.comiller.data.network.response.Login
import com.example.comiller.data.network.response.LoginResponse
import com.example.comiller.data.network.response.Register
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("login")
    suspend fun login(
        @Body login: Login
    ) : LoginResponse


    @POST("register")
    suspend fun register(
        @Body register: Register
    ) : LoginResponse
}