package com.example.comiller.data.network.response

data class LoginResponse(
    val data: LoginData,
    val message: String,
    val status: Int
)

data class LoginData(
    val status: Int,
    val token: Boolean,
    val user: User
)

data class User(
    val area_id: String,
    val created_at: String,
    val date: String,
    val email: String,
    val gander: String,
    val governorate_id: String,
    val id: Int,
    val img: String,
    val img_src: String,
    val name: String,
    val phone: String,
    val updated_at: String
)

data class ErrorResponse(
    val msg: String
)