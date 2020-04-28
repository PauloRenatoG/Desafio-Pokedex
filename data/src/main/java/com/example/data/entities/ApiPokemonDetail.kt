package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiPokemonDetail(
    @SerializedName("abilities")
    val abilities: List<ApiAbility>? = null,
    @SerializedName("base_experience")
    val baseExperience: Int? = null,
    @SerializedName("forms")
    val forms: List<ApiForm>? = null,
    @SerializedName("game_indices")
    val gameIndices: List<ApiGameIndice>? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("held_items")
    val heldItems: List<ApiHeldItems>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("is_default")
    val isDefault: Boolean? = null,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String? = null,
    @SerializedName("moves")
    val moves: List<ApiMove>? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("order")
    val order: Int? = null,
    @SerializedName("species")
    val species: ApiSpeciesUrl? = null,
    @SerializedName("sprites")
    val sprites: ApiSprites? = null,
    @SerializedName("stats")
    val stats: List<ApiStat>? = null,
    @SerializedName("types")
    val types: List<ApiType>? = null,
    @SerializedName("weight")
    val weight: Int? = null
)