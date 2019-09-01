package com.mo2o.recipesearcher.injector.component

import android.app.Application
import com.mo2o.recipesearcher.RecipeApplication
import com.mo2o.recipesearcher.injector.module.ActivityModule
import com.mo2o.recipesearcher.injector.module.NetworkModule
import com.mo2o.recipesearcher.injector.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityModule::class,
    NetworkModule::class,
    RepositoryModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: RecipeApplication)
}
