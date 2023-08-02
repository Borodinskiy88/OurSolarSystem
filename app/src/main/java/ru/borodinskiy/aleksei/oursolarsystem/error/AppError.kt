package ru.borodinskiy.aleksei.oursolarsystem.error

sealed class AppError(var code: String) : RuntimeException()
class ApiError(val status: Int, code: String) : AppError(code)
object NetworkError : AppError("error_network")