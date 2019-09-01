package com.mo2o.recipesearcher.data.api.model

data class RecipeResponse(
    val title: String,
    val href: String,
    val ingredients : String,
    val thumbnail: String
)