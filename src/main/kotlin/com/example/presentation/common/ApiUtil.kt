package com.example.presentation.common

import com.example.domain.model.ApiResponse

fun <T> showResponse(dataKey:String, data:T, responseCode:Int? = 200, message:String, ) : ApiResponse<HashMap<String, T>>{
    val mappedData = HashMap<String, T>()
    mappedData[dataKey] = data

    return ApiResponse(
        status = responseCode,
        message = message,
        data = mappedData,
    )
}