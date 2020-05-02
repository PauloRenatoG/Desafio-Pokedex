package com.example.desafiopokedex.view.base

import android.app.AlertDialog
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.desafiopokedex.R
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {
    val controller by lazy { findNavController() }
    lateinit var directions: NavDirections

    lateinit var baseViewModel: BaseViewModel

    internal fun setDialogError(error: String) {
        AlertDialog
            .Builder(context)
            .setTitle(R.string.error)
            .setMessage(error)
            .setPositiveButton(R.string.global_ok) { _, _ -> }
            .show()
    }
}