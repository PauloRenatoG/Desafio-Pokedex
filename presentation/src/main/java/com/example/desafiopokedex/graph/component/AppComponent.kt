package com.example.desafiopokedex.graph.component

import com.example.desafiopokedex.ApplicationComponent
import com.example.desafiopokedex.graph.module.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApiProviderModule::class,
        ActivityBindingModule::class,
        FragmentBindingModule::class,
        MapperModule::class,
        ApplicationBindModule::class
    ]
)
interface AppComponent : AndroidInjector<ApplicationComponent>