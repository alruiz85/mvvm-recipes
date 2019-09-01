package com.mo2o.recipesearcher.injector.module

import com.mo2o.recipesearcher.data.RecipesDataRepository
import com.mo2o.recipesearcher.data.api.RecipeApiService
import com.mo2o.recipesearcher.domain.repository.RecipesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providesRecipeRepository(apiMo2o: RecipeApiService): RecipesRepository {
        return RecipesDataRepository(apiMo2o)
    }
}