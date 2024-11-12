package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.ProductRepository
import com.emart.groceriesstore.di.IoDispatcher
import com.emart.groceriesstore.domain.usecases.SearchProductUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) :
    SearchProductUseCase {
    override suspend fun invoke(input: SearchProductUseCase.Input): SearchProductUseCase.Output {
        return withContext(ioDispatcher) {
            val result = productRepository.searchProductsListByName(input.name)
            SearchProductUseCase.Output(result)
        }
    }
}