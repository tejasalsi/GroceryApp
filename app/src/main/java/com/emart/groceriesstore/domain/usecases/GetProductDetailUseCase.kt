package com.emart.groceriesstore.domain.usecases

import com.emart.groceriesstore.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface GetProductDetailUseCase {
    fun getProductDetail(productId: String): Flow<ProductModel>
}

