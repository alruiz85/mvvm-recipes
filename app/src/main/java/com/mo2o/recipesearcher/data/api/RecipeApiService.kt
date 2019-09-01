package com.mo2o.recipesearcher.data.api

import com.mo2o.recipesearcher.data.api.model.RecipeSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {

    @GET("api/")
    fun searchRecipes(@Query("q") query: String): Call<RecipeSearchResponse>

}