package com.example.desafiopokedex.view.base

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {
    val controller by lazy { findNavController() }
    lateinit var directions: NavDirections
}