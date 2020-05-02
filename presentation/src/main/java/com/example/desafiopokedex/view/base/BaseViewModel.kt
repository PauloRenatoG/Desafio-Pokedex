package com.example.desafiopokedex.view.base

import androidx.lifecycle.*
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    val error: LiveData<String> get() = _error
    private val _error: MutableLiveData<String> = MutableLiveData()

    internal fun <T> asyncScope(
        block: suspend () -> T,
        onSuccess: (T) -> Unit,
        onFailure: ((Throwable) -> Unit)? = null
    ) {
        viewModelScope.launch {
            runCatching {
                block()
            }.onSuccess {
                onSuccess(it)
            }.onFailure {
                onFailure?.invoke(it)
            }
        }
    }

    internal fun setError(throwable: Throwable) {
        _error.postValue(throwable.message)
    }
}