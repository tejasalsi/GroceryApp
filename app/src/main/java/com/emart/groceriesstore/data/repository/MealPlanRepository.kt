package com.emart.groceriesstore.data.repository

import com.emart.groceriesstore.domain.models.MealModel

interface MealPlanRepository {
    suspend fun addMealToPlan(
        weekDay: String,
        name: String,
        ingredients: List<String>,
        mealType: String,
        mealImageUri: ByteArray
    )

    suspend fun retrieveMealByType(type: String, weekDayValue: String): List<MealModel>
    suspend fun removeMealFromPlan(id: String)
}