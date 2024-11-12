package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.MealPlanRepository
import com.emart.groceriesstore.di.IoDispatcher
import com.emart.groceriesstore.domain.models.MealModel
import com.emart.groceriesstore.domain.usecases.RetrieveMealByTypeUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrieveMealByTypeUseCaseImpl @Inject constructor(
    private val mealPlanRepository: MealPlanRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RetrieveMealByTypeUseCase {
    override suspend fun invoke(input: RetrieveMealByTypeUseCase.Input): RetrieveMealByTypeUseCase.Output {
        return withContext(ioDispatcher) {
            try {
                val result = mealPlanRepository.retrieveMealByType(
                    type = input.mealType.value,
                    weekDayValue = input.dayValue.dayValue
                )
                RetrieveMealByTypeUseCase.Output.Success(data = result)
            } catch (e: Exception) {
                RetrieveMealByTypeUseCase.Output.Failure
            }
        }
    }
}