package com.example.desafiopokedex.view.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel(), LifecycleObserver {


    internal fun <T> asyncScope(
        block: suspend () -> T,
        onSuccess: (T) -> Unit,
        onFailure: ((String) -> Unit)? = null
    ) {
        viewModelScope.launch {
            runCatching {
                block()
            }.onSuccess {
                onSuccess(it)
            }.onFailure {
                it.message?.let { message -> onFailure?.invoke(message) }
            }
        }
    }
}