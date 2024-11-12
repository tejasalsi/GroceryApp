package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.ProductRepository
import com.emart.groceriesstore.domain.usecases.GetProductsListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetProductsListUseCaseImpl @Inject constructor(private val productRepository: ProductRepository) :
    GetProductsListUseCase {
    override fun invoke(input: GetProductsListUseCase.Input): GetProductsListUseCase.Output {
        val result = productRepository.products
        return GetProductsListUseCase.Output(result)
    }
}
