package com.example.desafiopokedex.view.listpokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.desafiopokedex.view.base.BaseViewModel
import com.example.desafiopokedex.view.listpokemon.paging.ListPokemonDataSourceFactory
import com.example.domain.entity.ListNameSprite
import com.example.domain.usecase.GetListPokemon
import com.example.domain.usecase.GetSprites
import javax.inject.Inject

class ListPokemonViewModel @Inject constructor(
    private val getListPokemon: GetListPokemon,
    private val getSprites: GetSprites
) : BaseViewModel() {

    val loadingProgressBar: LiveData<Boolean> get() = _loadingProgressBar
    private val _loadingProgressBar: MutableLiveData<Boolean> = MutableLiveData()

    val listPokemon: LiveData<PagedList<ListNameSprite>> get() = _listPokemons
    private val _listPokemons by lazy { LivePagedListBuilder(dataSourceFactory, config).build() }

    private val dataSourceFactory = ListPokemonDataSourceFactory(
        getListPokemon,
        getSprites,
        _loadingProgressBar,
        viewModelScope,
        ::onFailure
    )

    private val config = PagedList.Config.Builder()
        .setPageSize(30)
        .setInitialLoadSizeHint(30)
        .setPrefetchDistance(10)
        .setEnablePlaceholders(false)
        .build()

    private fun onFailure(throwable: Throwable) {

    }
}