package com.emart.groceriesstore.data.network.dto

import com.squareup.moshi.Json

data class RecipeListResponse(
    @Json(name = "count") val count: String,
    @Json(name = "results") var recipesList: MutableList<RecipeDto> = mutableListOf()
)
