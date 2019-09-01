package com.mo2o.recipesearcher.data.api.model

class RecipeSearchResponse (
    val title:String,
    val version:String,
    val href:String,
    val results: List<RecipeResponse>
)