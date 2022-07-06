package com.example.comiller.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.comiller.data.network.response.ResultData

class ResultViewModel : ViewModel() {

    val resultData = MutableLiveData<ResultData>()

    fun setResultData(data: ResultData){
        resultData.value = data
    }
}