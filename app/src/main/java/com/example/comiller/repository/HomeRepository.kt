package com.example.comiller.repository

import com.example.comiller.SafeApiCall
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.interfaces.HomeApi
import com.example.comiller.data.network.response.Login
import com.example.comiller.data.network.response.Program1
import com.example.comiller.data.network.response.Program2
import com.example.comiller.data.network.response.Program3

class HomeRepository(
    private val api: HomeApi,
    private val preferences: UserPreferences? = null
): SafeApiCall {

    suspend fun program1(
        program1: Program1
    ) = safeApiCall {
        api.program1(program1)
    }

    suspend fun program2(
        program2: Program2
    ) = safeApiCall {
        api.program2(program2)
    }

    suspend fun program3(
        program3: Program3
    ) = safeApiCall {
        api.program3(program3)
    }

    suspend fun removeAcc(
        pass: String
    ) = safeApiCall {
        api.remove(pass)
    }
}