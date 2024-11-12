package com.emart.groceriesstore.di

import com.emart.groceriesstore.domain.usecases.AddMealToPlanUseCase
import com.emart.groceriesstore.domain.usecases.AddToCartUseCase
import com.emart.groceriesstore.domain.usecases.impl.AddToCartUseCaseImpl
import com.emart.groceriesstore.domain.usecases.CreateNewOrderUseCase
import com.emart.groceriesstore.domain.usecases.impl.CreateNewOrderUseCaseImpl
import com.emart.groceriesstore.domain.usecases.GetCategoriesListUseCase
import com.emart.groceriesstore.domain.usecases.impl.GetCategoriesListUseCaseImpl
import com.emart.groceriesstore.domain.usecases.GetCurrentCartUseCase
import com.emart.groceriesstore.domain.usecases.GetOrderListUseCase
import com.emart.groceriesstore.domain.usecases.impl.GetCurrentCartUseCaseImpl
import com.emart.groceriesstore.domain.usecases.GetProductDetailUseCase
import com.emart.groceriesstore.domain.usecases.impl.GetProductDetailUseCaseImpl
import com.emart.groceriesstore.domain.usecases.GetProductsByCategoryUseCase
import com.emart.groceriesstore.domain.usecases.impl.GetProductsByCategoryUseCaseImpl
import com.emart.groceriesstore.domain.usecases.GetProductsListUseCase
import com.emart.groceriesstore.domain.usecases.impl.GetProductsListUseCaseImpl
import com.emart.groceriesstore.domain.usecases.GetProfileUseCase
import com.emart.groceriesstore.domain.usecases.impl.GetProfileUseCaseImpl
import com.emart.groceriesstore.domain.usecases.RefreshAppDataUseCase
import com.emart.groceriesstore.domain.usecases.RemoveMealFromPlanUseCase
import com.emart.groceriesstore.domain.usecases.RetrieveMealByTypeUseCase
import com.emart.groceriesstore.domain.usecases.impl.RefreshAppDataUseCaseImpl
import com.emart.groceriesstore.domain.usecases.SearchProductUseCase
import com.emart.groceriesstore.domain.usecases.impl.SearchProductUseCaseImpl
import com.emart.groceriesstore.domain.usecases.SignInUseCase
import com.emart.groceriesstore.domain.usecases.impl.SignInUseCaseImpl
import com.emart.groceriesstore.domain.usecases.SignOutUseCase
import com.emart.groceriesstore.domain.usecases.impl.SignOutUseCaseImpl
import com.emart.groceriesstore.domain.usecases.SubmitOrderUseCase
import com.emart.groceriesstore.domain.usecases.impl.SubmitOrderUseCaseImpl
import com.emart.groceriesstore.domain.usecases.UpdateCartItemUseCase
import com.emart.groceriesstore.domain.usecases.impl.UpdateCartItemUseCaseImpl
import com.emart.groceriesstore.domain.usecases.UpdateProfileUseCase
import com.emart.groceriesstore.domain.usecases.impl.UpdateProfileUseCaseImpl
import com.emart.groceriesstore.domain.usecases.UserSettingsUseCase
import com.emart.groceriesstore.domain.usecases.impl.AddMealToPlanUseCaseImpl
import com.emart.groceriesstore.domain.usecases.impl.GetOrderListUseCaseImpl
import com.emart.groceriesstore.domain.usecases.impl.RemoveMealFromPlanUseCaseImpl
import com.emart.groceriesstore.domain.usecases.impl.RetrieveMealByTypeUseCaseImpl
import com.emart.groceriesstore.domain.usecases.impl.UserSettingsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseModule {
    @ViewModelScoped
    @Binds
    abstract fun bindGetProductsListUseCase(impl: GetProductsListUseCaseImpl): GetProductsListUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindGetProductDetailUseCase(impl: GetProductDetailUseCaseImpl): GetProductDetailUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindUpdateCartItemUseCase(impl: UpdateCartItemUseCaseImpl): UpdateCartItemUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindRefreshAppDataUseCase(impl: RefreshAppDataUseCaseImpl): RefreshAppDataUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindUserSettingsUseCase(impl: UserSettingsUseCaseImpl): UserSettingsUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindSignInUseCase(impl: SignInUseCaseImpl): SignInUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindSignOutUseCase(impl: SignOutUseCaseImpl): SignOutUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindSignOutGetProfileUseCase(impl: GetProfileUseCaseImpl): GetProfileUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindGetCurrentCartUseCase(impl: GetCurrentCartUseCaseImpl): GetCurrentCartUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindAddToCartUseCase(impl: AddToCartUseCaseImpl): AddToCartUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindCreateNewOrderUseCase(impl: CreateNewOrderUseCaseImpl): CreateNewOrderUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindGetProductsByCategoryUseCase(impl: GetProductsByCategoryUseCaseImpl): GetProductsByCategoryUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindUpdateProfileUseCase(impl: UpdateProfileUseCaseImpl): UpdateProfileUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindSubmitOrderUseCase(impl: SubmitOrderUseCaseImpl): SubmitOrderUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindGetCategoriesListUseCase(impl: GetCategoriesListUseCaseImpl): GetCategoriesListUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindSearchProductUseCase(impl: SearchProductUseCaseImpl): SearchProductUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindGetOrdersUseCase(impl: GetOrderListUseCaseImpl): GetOrderListUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindAddMealToPlan(impl: AddMealToPlanUseCaseImpl): AddMealToPlanUseCase

    @ViewModelScoped
    @Binds
    abstract fun bindRetrieveMealByType(impl: RetrieveMealByTypeUseCaseImpl): RetrieveMealByTypeUseCase


    @ViewModelScoped
    @Binds
    abstract fun bindRemoveMealFromPlan(impl: RemoveMealFromPlanUseCaseImpl): RemoveMealFromPlanUseCase

}
