package net.aqua_waterfliter.jo.confirmation.data.network

import com.example.comiller.responce.ErrorResponse
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


import retrofit2.HttpException
import java.io.IOException

interface SafeApiCall {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultWrapper<T> {
        return withContext(Dispatchers.IO) {
            try {
                ResultWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> ResultWrapper.GenericError(true, null, throwable.message)
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = convertErrorBody(throwable)
                        ResultWrapper.GenericError(errorCode = code, error = errorResponse)
                    }
                    else -> {
                        ResultWrapper.GenericError(errorCode = null, error = throwable.message)
                    }
                }
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}
