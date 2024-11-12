package com.emart.groceriesstore.domain.usecases

import com.emart.groceriesstore.domain.models.MealModel
import com.emart.groceriesstore.presentation.mealplanning.overview.state.MealType
import com.emart.groceriesstore.presentation.mealplanning.overview.state.WeekDayValue

interface RetrieveMealByTypeUseCase :
    SuspendUseCase<RetrieveMealByTypeUseCase.Input, RetrieveMealByTypeUseCase.Output> {
    class Input(
        val dayValue: WeekDayValue,
        val mealType: MealType,
    )

    sealed class Output {
        class Success(val data: List<MealModel>) : Output()
        data object Failure : Output()
    }
}