package com.mo2o.recipesearcher.data.extension

import com.mo2o.recipesearcher.data.api.model.RecipeResponse
import com.mo2o.recipesearcher.data.api.model.RecipeSearchResponse
import com.mo2o.recipesearcher.domain.model.Recipe

fun RecipeSearchResponse.toDomain() = results.map { it.toDomain() }

fun RecipeResponse.toDomain() = Recipe(title, href, ingredients, thumbnail)