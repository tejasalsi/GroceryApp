package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.CategoryRepository
import com.emart.groceriesstore.domain.usecases.GetCategoriesListUseCase
import javax.inject.Inject

class GetCategoriesListUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoriesListUseCase {
    override suspend fun invoke(input: GetCategoriesListUseCase.Input): GetCategoriesListUseCase.Output {
        val result = categoryRepository.getFromLocal()
        return GetCategoriesListUseCase.Output(result)
    }
}