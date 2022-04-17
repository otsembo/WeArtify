package com.example.presentation.common

import com.example.domain.model.ApiResponse
import io.ktor.http.*

fun <T> showResponse(dataKey:String, data:T, responseCode:Int = 200, message:String, ) : ApiResponse<HashMap<String, T>>{
    val mappedData = HashMap<String, T>()
    mappedData[dataKey] = data

    return ApiResponse(
        status = responseCode,
        message = message,
        data = mappedData,
    )
}

fun Parameters.paramToInt(name:String, default:Int) : Int {
    return when(val appParam = this[name]){
        null -> default
        else -> try{appParam.toInt()}catch (ex:Exception){default}
    }
}