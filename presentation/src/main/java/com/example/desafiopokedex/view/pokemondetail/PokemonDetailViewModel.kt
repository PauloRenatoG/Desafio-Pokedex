package com.example.desafiopokedex.view.pokemondetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.desafiopokedex.view.base.BaseViewModel
import com.example.domain.entity.PokemonDetail
import com.example.domain.usecase.GetPokemonDetail
import javax.inject.Inject

class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetail: GetPokemonDetail
) : BaseViewModel() {

    val pokemonDetail: LiveData<PokemonDetail> get() = _pokemonDetail
    private val _pokemonDetail: MutableLiveData<PokemonDetail> = MutableLiveData()

    internal fun onCreate(name: String) {
        asyncScope(
            block = { getPokemonDetail.execute(name) },
            onSuccess = { _pokemonDetail.postValue(it) },
            onFailure = { onFailure(it) }
        )
    }

    private fun onFailure(throwable: String) {

    }
}