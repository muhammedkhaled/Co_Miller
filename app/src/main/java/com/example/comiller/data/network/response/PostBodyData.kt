package com.example.comiller.data.network.response

data class Login(
    val email: String,
    val password: String
)

data class Register(
    val name: String,
    val email: String,
    val phone: String,
    val password: String
)

data class Program1(
    val moisture: String,
    val protein: String,
    val ash: String,
    val wetGluten: String,
    val glutenIndex: String
)

data class Program2(
    val moisture: String,
    val kernelSize: String,
    val singleKernel: String
)

data class Program3(
    val panBread: String,
    val crumbGrain: String,
    val loafVolume: String
)