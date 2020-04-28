package com.example.desafiopokedex.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified VM : ViewModel> Fragment.viewModelProvider(
    factory: ViewModelProvider.Factory
) = ViewModelProvider(this, factory).get(VM::class.java)

inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider(
    factory: ViewModelProvider.Factory
) = ViewModelProvider(this, factory).get(VM::class.java)