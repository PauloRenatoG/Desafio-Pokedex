package com.example.desafiopokedex.graph.component

import com.example.desafiopokedex.ApplicationComponent
import com.example.desafiopokedex.graph.module.ActivityBindingModule
import com.example.desafiopokedex.graph.module.ApiProviderModule
import com.example.desafiopokedex.graph.module.FragmentBindingModule
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
        FragmentBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<ApplicationComponent>