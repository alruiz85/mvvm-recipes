package com.mo2o.recipesearcher.data

import com.mo2o.recipesearcher.data.api.RecipeApiService
import retrofit2.Call
import retrofit2.Response
import java.net.UnknownHostException

open class BaseRepository (val apiService: RecipeApiService) {

    @Throws(Exception::class)
    fun executeCall(call: Call<*>): Response<*> {
        val response = call.execute()
        if (!response.isSuccessful) {
            throw UnknownHostException()
        } else {
            return response
        }
    }
}