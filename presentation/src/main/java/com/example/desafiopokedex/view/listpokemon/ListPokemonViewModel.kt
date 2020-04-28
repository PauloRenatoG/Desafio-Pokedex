package com.example.desafiopokedex.view.listpokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.desafiopokedex.view.base.BaseViewModel
import com.example.desafiopokedex.view.listpokemon.paging.ListPokemonDataSourceFactory
import com.example.domain.entity.Result
import com.example.domain.usecase.GetListPokemon
import javax.inject.Inject

class ListPokemonViewModel @Inject constructor(
    private val getListPokemon: GetListPokemon
) : BaseViewModel() {

    val listPokemon: LiveData<PagedList<Result>> get() = _listPokemons
    private val _listPokemons by lazy { LivePagedListBuilder(dataSourceFactory, config).build() }
    private val dataSourceFactory = ListPokemonDataSourceFactory(
        getListPokemon,
        viewModelScope,
        ::onFailure
    )
    private val config = PagedList.Config.Builder()
        .setPageSize(20)
        .setInitialLoadSizeHint(20)
        .setPrefetchDistance(10)
        .setEnablePlaceholders(false)
        .build()

    private fun onFailure(throwable: Throwable) {

    }
}