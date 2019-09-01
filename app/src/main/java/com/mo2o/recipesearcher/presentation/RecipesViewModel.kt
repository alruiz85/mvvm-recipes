package com.mo2o.recipesearcher.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo2o.recipesearcher.domain.model.Recipe
import com.mo2o.recipesearcher.domain.repository.RecipesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipesViewModel(private val recipesRepository: RecipesRepository) : ViewModel() {

    private val recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun search(ingredient: String = "") {
        viewModelScope.launch {
            requestRecipes(ingredient)
        }
    }

    private suspend fun requestRecipes(ingredient: String) = withContext(Dispatchers.Default) {
        try {
            recipes.postValue(recipesRepository.searchRecipes(ingredient))
        } catch (e: Exception) {
            error.postValue(e.message)
        }
    }

    fun getRecipes() = recipes

    fun getError() = error

}