package com.mo2o.recipesearcher.injector.module

import com.mo2o.recipesearcher.presentation.RecipesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): RecipesActivity
}