package com.example.comiller.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comiller.data.cash.UserPreferences
import com.example.comiller.data.network.RemoteDataSource
import com.example.comiller.data.network.interfaces.HomeApi
import com.example.comiller.data.network.response.LoginResponse
import com.example.comiller.data.network.response.ResultData
import com.example.comiller.repository.HomeRepository
import kotlinx.coroutines.launch
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper

class ProfileViewModel : ViewModel() {
    private val dataSource = RemoteDataSource()
    private val api = dataSource.buildApi(HomeApi::class.java)
    private val repository = HomeRepository(api)


    private val __removeAcc: MutableLiveData<ResultWrapper<LoginResponse>> = MutableLiveData()
    val removeAcc: MutableLiveData<ResultWrapper<LoginResponse>>
        get() = __removeAcc

    fun removeAcc(pass: String) = viewModelScope.launch {
        __removeAcc.value = ResultWrapper.Loading
        __removeAcc.value = repository.removeAcc(pass)
    }
}