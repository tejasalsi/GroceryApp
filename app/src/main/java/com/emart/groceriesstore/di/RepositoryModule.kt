package com.emart.groceriesstore.di

import com.emart.groceriesstore.data.repository.impl.CategoryRepositoryImpl
import com.emart.groceriesstore.data.repository.impl.OrderRepositoryImpl
import com.emart.groceriesstore.data.repository.impl.ProductRepositoryImpl
import com.emart.groceriesstore.data.repository.impl.RecipeRepositoryImpl
import com.emart.groceriesstore.data.repository.impl.UserRepositoryImpl
import com.emart.groceriesstore.data.repository.CategoryRepository
import com.emart.groceriesstore.data.repository.MealPlanRepository
import com.emart.groceriesstore.data.repository.OrderRepository
import com.emart.groceriesstore.data.repository.ProductRepository
import com.emart.groceriesstore.data.repository.RecipeRepository
import com.emart.groceriesstore.data.repository.UserRepository
import com.emart.groceriesstore.data.repository.impl.MealPlanRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(impl: ProductRepositoryImpl): ProductRepository

    @Singleton
    @Binds
    abstract fun bindOrderRepository(impl: OrderRepositoryImpl): OrderRepository

    @Singleton
    @Binds
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository

    @Singleton
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun bindRecipeRepository(impl: RecipeRepositoryImpl): RecipeRepository

    @Singleton
    @Binds
    abstract fun bindMealRepository(impl: MealPlanRepositoryImpl): MealPlanRepository
}
