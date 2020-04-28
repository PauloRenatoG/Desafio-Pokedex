package com.example.desafiopokedex.view.listpokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiopokedex.databinding.FragmentListPokemonBinding
import com.example.desafiopokedex.util.viewModelProvider
import com.example.desafiopokedex.view.base.BaseFragment
import javax.inject.Inject

class ListPokemonFragment : BaseFragment() {

    private lateinit var binding: FragmentListPokemonBinding
    private lateinit var viewModel: ListPokemonViewModel
    private val adapterList: ListPokemonAdapter = ListPokemonAdapter()

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentListPokemonBinding.inflate(inflater, container, false)

        viewModel = viewModelProvider(viewModelFactory)
        lifecycle.addObserver(viewModel)
        setupRecycler()
        subscribeUI()
        return binding.root
    }

    private fun subscribeUI() {
        viewModel.listPokemon.observe(viewLifecycleOwner, Observer { list ->
            adapterList.submitList(list)
        })
    }

    private fun setupRecycler() {
        with(binding.recyclerViewPokemon) {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterList
            val decor = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            addItemDecoration(decor)
        }
    }
}