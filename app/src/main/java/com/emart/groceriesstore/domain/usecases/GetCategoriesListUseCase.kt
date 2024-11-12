package com.emart.groceriesstore.domain.usecases

import com.emart.groceriesstore.domain.models.CategoryModel
import kotlinx.coroutines.flow.Flow

interface GetCategoriesListUseCase :
    SuspendUseCase<GetCategoriesListUseCase.Input, GetCategoriesListUseCase.Output> {
    class Input

    class Output(val result: Flow<List<CategoryModel>>)
}
