package com.example.desafiopokedex.view.pokemondetail

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.desafiopokedex.util.NAME_POKEMON
import com.example.desafiopokedex.view.base.BaseViewModel
import com.example.domain.entity.EffectEntries
import com.example.domain.entity.ListPokemonType
import com.example.domain.entity.PokemonDetail
import com.example.domain.usecase.GetAbility
import com.example.domain.usecase.GetPokemonDetail
import com.example.domain.usecase.GetSamePokemonType
import javax.inject.Inject
import javax.inject.Named

class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetail: GetPokemonDetail,
    private val getAbility: GetAbility,
    private val getSamePokemonType: GetSamePokemonType,
    @Named(NAME_POKEMON) private val name: String
) : BaseViewModel() {

    val pokemonDetail: LiveData<PokemonDetail> get() = _pokemonDetail
    private val _pokemonDetail: MutableLiveData<PokemonDetail> = MutableLiveData()

    val ability: LiveData<EffectEntries> get() = _ability
    private val _ability: MutableLiveData<EffectEntries> = MutableLiveData()

    val samePokemonType: LiveData<ListPokemonType> get() = _samePokemonType
    private val _samePokemonType: MutableLiveData<ListPokemonType> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        asyncScope(
            block = { getPokemonDetail.execute(name) },
            onSuccess = { _pokemonDetail.postValue(it) },
            onFailure = { onFailure(it) }
        )
    }

    internal fun getAbility(name: String) {
        asyncScope(
            block = { getAbility.execute(name) },
            onSuccess = { _ability.postValue(it) },
            onFailure = { onFailure(it) }
        )
    }

    internal fun getType(name: String) {
        asyncScope(
            block = { getSamePokemonType.execute(name) },
            onSuccess = { _samePokemonType.postValue(it) },
            onFailure = { onFailure(it) }
        )
    }

    private fun onFailure(throwable: String) {

    }
}