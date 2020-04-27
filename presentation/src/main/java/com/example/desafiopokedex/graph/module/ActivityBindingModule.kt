package com.example.desafiopokedex.graph.module

import com.example.desafiopokedex.graph.scope.ActivityScope
import com.example.desafiopokedex.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun contributesMainActivity(): MainActivity
}