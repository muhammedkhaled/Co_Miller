package com.example.comiller.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comiller.data.network.response.Login
import com.example.comiller.data.network.response.LoginResponse
import com.example.comiller.data.network.response.Register
import com.example.comiller.repository.AuthRepository
import kotlinx.coroutines.launch
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _loginResponse: MutableLiveData<ResultWrapper<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<ResultWrapper<LoginResponse>>
        get() = _loginResponse

    fun login(
        login: Login
    ) = viewModelScope.launch {
        _loginResponse.value = ResultWrapper.Loading
        _loginResponse.value = repository.login(login)
    }

    private val _registerResponse: MutableLiveData<ResultWrapper<LoginResponse>> = MutableLiveData()
    val registerResponse: LiveData<ResultWrapper<LoginResponse>>
        get() = _registerResponse

    fun register(
        register: Register
    ) = viewModelScope.launch {
        _registerResponse.value = ResultWrapper.Loading
        _registerResponse.value = repository.register(register)
    }

    suspend fun saveAccessTokens(
        accessToken: String,
        userEmail: String,
        userName: String,
        userPhone: String
    ) {
        repository.saveAccessTokens(accessToken, userEmail, userName, userPhone)
    }
}