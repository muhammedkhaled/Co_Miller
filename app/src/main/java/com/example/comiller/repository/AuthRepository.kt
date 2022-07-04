package com.example.comiller.repository

import com.example.comiller.SafeApiCall
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.interfaces.AuthApi
import com.example.comiller.data.network.response.Login
import com.example.comiller.data.network.response.Register


class AuthRepository (
    private val api: AuthApi,
    private val preferences: UserPreferences
): SafeApiCall {

    suspend fun login(
        login: Login
    ) = safeApiCall {
        api.login(login)
    }

    suspend fun register(
        register: Register
    ) = safeApiCall {
        api.register(register)
    }

    suspend fun saveAccessTokens(accessToken: String, userEmail: String, userName: String, userPhone: String) {
        preferences.saveAccessTokens(accessToken, userEmail, userName, userPhone)
    }
}