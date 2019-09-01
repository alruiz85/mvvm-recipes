package com.mo2o.recipesearcher.domain.usecase

import com.mo2o.recipesearcher.domain.repository.RecipesRepository
import javax.inject.Inject

class SearchRecipesUseCase<T>
@Inject constructor(private val recipesRepository: RecipesRepository): UseCase<T>() {

    var ingredient: String = ""

    override suspend fun execution() = recipesRepository.searchRecipes(ingredient)
}