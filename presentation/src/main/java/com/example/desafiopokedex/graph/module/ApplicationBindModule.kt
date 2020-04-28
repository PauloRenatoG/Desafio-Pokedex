package com.example.desafiopokedex.graph.module

import androidx.lifecycle.ViewModelProvider
import com.example.data.repository.GetListResultRepositoryImpl
import com.example.data.repository.GetSpritesRepositoryImpl
import com.example.desafiopokedex.view.base.ViewModelFactory
import com.example.domain.repository.GetListResultRepository
import com.example.domain.repository.GetSpritesRepository
import dagger.Binds
import dagger.Module

@Module
interface ApplicationBindModule {

    @Binds
    fun bindsGetListResultRepository(repository: GetListResultRepositoryImpl): GetListResultRepository

    @Binds
    fun bindsGetSpritesRepository(repository: GetSpritesRepositoryImpl): GetSpritesRepository

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}