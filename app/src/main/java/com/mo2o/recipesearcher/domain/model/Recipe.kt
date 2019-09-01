package com.mo2o.recipesearcher.domain.model

data class Recipe(
    val title: String,
    val href: String,
    val ingredients : String,
    val thumbnail: String
)