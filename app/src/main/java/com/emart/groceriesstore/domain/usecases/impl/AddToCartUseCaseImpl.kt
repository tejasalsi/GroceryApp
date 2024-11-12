package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.OrderRepository
import com.emart.groceriesstore.di.IoDispatcher
import com.emart.groceriesstore.domain.usecases.AddToCartUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddToCartUseCaseImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) :
    AddToCartUseCase {
    override suspend fun invoke(input: AddToCartUseCase.Input): AddToCartUseCase.Output {
        withContext(ioDispatcher) {
            orderRepository.addLineItem(input.lineItem)
        }
        return AddToCartUseCase.Output()
    }
}