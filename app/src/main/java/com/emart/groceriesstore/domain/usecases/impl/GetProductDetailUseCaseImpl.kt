package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.ProductRepository
import com.emart.groceriesstore.domain.usecases.GetProductDetailUseCase
import javax.inject.Inject

class GetProductDetailUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
) : GetProductDetailUseCase {
    override fun getProductDetail(productId: String) = productRepository.getProductById(productId)
}

