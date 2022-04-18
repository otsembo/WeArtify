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
    return when(val appParam:String? = this[name]){
        null -> default
        else -> try{
            appParam.toInt()
        }catch (ex:Exception){default}
    }
}


object ApiExtensions {
    //endpoint extensions
    const val CLIENT_ENDPOINT = "/client"
    const val ADMIN_ENDPOINT = "/admin"
    const val SELLER_ENDPOINT = "/seller"
}


object ApiMessages{


    const val SUCCESS = "success"
    const val FAILED = "failed"

    const val POSTED = "posted"

}