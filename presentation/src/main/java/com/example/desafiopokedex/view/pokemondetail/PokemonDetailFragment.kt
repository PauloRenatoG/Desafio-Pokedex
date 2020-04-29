package com.example.desafiopokedex.view.pokemondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.desafiopokedex.databinding.FragmentPokemonDetailBinding
import com.example.desafiopokedex.util.viewModelProvider
import com.example.desafiopokedex.view.base.BaseFragment
import com.example.domain.entity.Sprites
import javax.inject.Inject
import kotlin.math.abs

class PokemonDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentPokemonDetailBinding
    private lateinit var viewModel: PokemonDetailViewModel
    private val nav by navArgs<PokemonDetailFragmentArgs>()
    private val name: String by lazy { nav.pokemonName }
    private val listSprites: MutableList<String> = mutableListOf()

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)

        viewModel = viewModelProvider(viewModelFactory)
        subscribeUI()
        return binding.root
    }

    private fun subscribeUI() {
        with(viewModel) {
            onCreate(name)
            pokemonDetail.observe(viewLifecycleOwner, Observer { pokemon ->
                binding.textName.text = pokemon.name
                binding.textStack.text = pokemon.stats
                    ?.map {
                        it.stat?.name
                    }?.joinToString(separator = ", ")
                pokemon.sprites?.let { convertSpritesToList(it) }
            })
        }
    }

    private fun setupViewPager() {
        with(binding) {
            viewPagerSprite.adapter = PokemonDetailAdapter(listSprites)
            viewPagerSprite.clipToPadding = false
            viewPagerSprite.clipChildren = false
            viewPagerSprite.offscreenPageLimit = 3
            viewPagerSprite.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleX = 0.95f + r * 0.05f
        }

        binding.viewPagerSprite.setPageTransformer(compositePageTransformer)
    }

    private fun convertSpritesToList(sprites: Sprites) {
        with(sprites) {
            backDefault?.let { listSprites.add(it) }
            backFemale?.let { listSprites.add(it) }
            backShiny?.let { listSprites.add(it) }
            backShinyFemale?.let { listSprites.add(it) }
            frontDefault?.let { listSprites.add(it) }
            frontFemale?.let { listSprites.add(it) }
            frontShiny?.let { listSprites.add(it) }
            frontShinyFemale?.let { listSprites.add(it) }
        }
        setupViewPager()
    }
}