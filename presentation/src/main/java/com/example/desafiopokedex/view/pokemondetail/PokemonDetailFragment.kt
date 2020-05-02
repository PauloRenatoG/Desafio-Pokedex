package com.example.desafiopokedex.view.pokemondetail

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.desafiopokedex.R
import com.example.desafiopokedex.databinding.FragmentPokemonDetailBinding
import com.example.desafiopokedex.util.viewModelProvider
import com.example.desafiopokedex.view.base.BaseFragment
import com.example.desafiopokedex.view.pokemondetail.recyclerability.PokemonAbilityATypeAdapter
import com.example.desafiopokedex.view.pokemondetail.recyclersametypepokemon.ListPokemonSameTypeAdapter
import com.example.desafiopokedex.view.pokemondetail.recyclersprites.PokemonSpriteAdapter
import com.example.domain.entity.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet_list_same_type_pokemon.*
import javax.inject.Inject
import kotlin.math.abs

class PokemonDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentPokemonDetailBinding
    private lateinit var viewModel: PokemonDetailViewModel
    private val nav by navArgs<PokemonDetailFragmentArgs>()
    private val listSprites: MutableList<String> = mutableListOf()
    private lateinit var adapterList: PokemonAbilityATypeAdapter
    private lateinit var bottomSheet: BottomSheetDialog
    val name: String by lazy { nav.pokemonName }

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
        lifecycle.addObserver(viewModel)
        return binding.root
    }

    private fun subscribeUI() {
        with(viewModel) {
            pokemonDetail.observe(viewLifecycleOwner, Observer { pokemon ->
                setupBinding(pokemon)
                pokemon.id?.let { viewModel.getEvolution(it) }
            })
            ability.observe(viewLifecycleOwner, Observer { effectEntry ->
                setDialogAbilityDescription(effectEntry.effectEntries?.get(0)?.effect)
            })
            samePokemonType.observe(viewLifecycleOwner, Observer {
                setDialogTypeDescription(it)
            })
            evolution.observe(viewLifecycleOwner, Observer { evolution ->
                setupEvolution(evolution)
            })
        }
    }

    private fun setupEvolution(evolution: Evolution) {
        binding.textEvolution.text =
            listOf(evolution.chain?.speciesUrl?.name,
                evolution.chain?.evolvesTo?.let {
                    if (!it.isNullOrEmpty()) it[0].speciesUrl.name else ""
                },
                evolution.chain?.evolvesTo?.get(0)?.evolvesTo?.let {
                    if (!it.isNullOrEmpty()) it[0].speciesUrl.name else ""
                }
            ).joinToString(", ")

    }

    private fun setupBinding(pokemon: PokemonDetail) {
        binding.textName.text = pokemon.name
        binding.textStack.text = pokemon.stats
            ?.map {
                it.stat?.name
            }?.joinToString(separator = ", ")
        pokemon.sprites?.let { convertSpritesToList(it) }
        setupViewPager()
        setupRecyclerAbility(pokemon.abilities)
        setupRecyclerType(pokemon.types)
    }

    private fun setupViewPager() {
        with(binding) {
            viewPagerSprite.adapter = PokemonSpriteAdapter(listSprites)
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

    private fun setupRecyclerAbility(abilities: List<Ability>?) {
        adapterList =
            PokemonAbilityATypeAdapter(
                abilities?.map { it.ability?.name },
                viewModel::getAbility
            )
        with(binding.recyclerAbility) {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = adapterList
        }
    }

    private fun setupRecyclerType(type: List<Type>?) {
        adapterList = PokemonAbilityATypeAdapter(
            type?.map { it.type?.name },
            viewModel::getType
        )
        with(binding.recyclerType) {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = adapterList
        }
    }

    private fun setDialogAbilityDescription(message: String?) {
        AlertDialog
            .Builder(context)
            .setTitle(R.string.ability)
            .setMessage(message)
            .setPositiveButton(R.string.global_ok) { _, _ -> }
            .show()
    }

    private fun setDialogTypeDescription(listPokemonType: ListPokemonType) {
        context?.let {
            bottomSheet = BottomSheetDialog(
                it,
                R.style.BottomSheetDialogTheme
            )
            bottomSheet.setContentView(R.layout.bottom_sheet_list_same_type_pokemon)
            with(bottomSheet.recycler_same_type) {
                layoutManager = LinearLayoutManager(context)
                adapter = ListPokemonSameTypeAdapter(listPokemonType.pokemon)
                val decor = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                addItemDecoration(decor)
            }
            bottomSheet.show()
        }
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
    }
}