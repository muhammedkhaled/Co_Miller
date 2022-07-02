package net.aqua_waterfliter.jo.confirmation.data.network


sealed class ResultWrapper<out T> {

    data class Success<out T>(val value: T) : ResultWrapper<T>()

    data class GenericError(
        val isNetworkError: Boolean? = null,
        val errorCode: Int?,
        val error: Any? = null
    ) : ResultWrapper<Nothing>()

    object Loading : ResultWrapper<Nothing>()

}