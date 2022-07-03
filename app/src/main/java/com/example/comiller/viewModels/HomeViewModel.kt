package com.example.comiller.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comiller.data.network.response.*
import com.example.comiller.repository.HomeRepository
import kotlinx.coroutines.launch
import net.aqua_waterfliter.jo.confirmation.data.network.ResultWrapper

class HomeViewModel (private val repository: HomeRepository) : ViewModel() {
    private val _programTest: MutableLiveData<ResultWrapper<ResultData>> = MutableLiveData()
    val programTest: LiveData<ResultWrapper<ResultData>>
        get() = _programTest

    fun program1(
        program1: Program1
    ) = viewModelScope.launch {
        _programTest.value = ResultWrapper.Loading
        _programTest.value = repository.program1(program1)
    }

    fun program2(
        program2: Program2
    ) = viewModelScope.launch {
        _programTest.value = ResultWrapper.Loading
        _programTest.value = repository.program2(program2)
    }

    fun program3(
        program3: Program3
    ) = viewModelScope.launch {
        _programTest.value = ResultWrapper.Loading
        _programTest.value = repository.program3(program3)
    }
}