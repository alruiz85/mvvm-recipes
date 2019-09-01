package com.mo2o.recipesearcher.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mo2o.recipesearcher.domain.repository.RecipesRepository
import javax.inject.Inject

class RecipesViewModelFactory
@Inject constructor(private val repository: RecipesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipesViewModel::class.java)) {
            return RecipesViewModel(repository) as T
        }
        throw IllegalArgumentException()
    }
}
