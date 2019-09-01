package com.mo2o.recipesearcher.domain.repository

import com.mo2o.recipesearcher.domain.model.Recipe

interface RecipesRepository {
    fun searchRecipes(ingredient: String): List<Recipe>
}