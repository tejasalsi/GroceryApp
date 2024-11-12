package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.MealPlanRepository
import com.emart.groceriesstore.domain.usecases.AddMealToPlanUseCase
import javax.inject.Inject

class AddMealToPlanUseCaseImpl @Inject constructor(
    private val mealPlanRepository: MealPlanRepository
) : AddMealToPlanUseCase {
    override suspend fun invoke(input: AddMealToPlanUseCase.Input): AddMealToPlanUseCase.Output {
        mealPlanRepository.addMealToPlan(
            weekDay = input.weekDay,
            name = input.name,
            ingredients = input.ingredients,
            mealType = input.mealType.value,
            mealImageUri = input.mealImageUri
        )
        return AddMealToPlanUseCase.Output
    }
}