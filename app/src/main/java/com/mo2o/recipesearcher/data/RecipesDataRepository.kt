package com.mo2o.recipesearcher.data

import com.mo2o.recipesearcher.data.api.RecipeApiService
import com.mo2o.recipesearcher.data.api.model.RecipeSearchResponse
import com.mo2o.recipesearcher.data.extension.toDomain
import com.mo2o.recipesearcher.domain.model.Recipe
import com.mo2o.recipesearcher.domain.repository.RecipesRepository
import retrofit2.Response

class RecipesDataRepository(apiService: RecipeApiService): BaseRepository(apiService),
    RecipesRepository {

    override fun searchRecipes(ingredient: String): List<Recipe> {
        val response: Response<*> = executeCall(apiService.searchRecipes(ingredient))
        return  (response.body() as RecipeSearchResponse).toDomain()
    }
}