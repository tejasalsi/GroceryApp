package com.emart.groceriesstore.domain.usecases

import com.emart.groceriesstore.presentation.mealplanning.overview.state.MealType

interface AddMealToPlanUseCase :
    SuspendUseCase<AddMealToPlanUseCase.Input, AddMealToPlanUseCase.Output> {
    class Input(
        val name: String,
        val weekDay: String,
        val ingredients: List<String>,
        val mealType: MealType,
        val mealImageUri: ByteArray,
    )

    object Output
}