package com.example.kotlin.kotlindemo.error

/**
 * Created by Nemanja on 6/9/17.
 */
class StudentException(message: String?, errorCode: ErrorCode) : Exception(message) {
    val errorCode: ErrorCode = errorCode
}