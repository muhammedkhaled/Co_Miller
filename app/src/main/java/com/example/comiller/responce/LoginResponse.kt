package com.example.comiller.responce


data class LoginResponse(
    val Token: String,
    val Email: String,
    val agentNum: String
)

data class ErrorResponse(
    val msg: String
)

data class Login(
    val email: String,
    val password: String
)