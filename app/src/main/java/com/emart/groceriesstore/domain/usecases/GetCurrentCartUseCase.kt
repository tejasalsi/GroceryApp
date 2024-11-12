package com.emart.groceriesstore.domain.usecases

import com.emart.groceriesstore.domain.models.OrderModel
import kotlinx.coroutines.flow.Flow

interface GetCurrentCartUseCase :
    SuspendUseCase<GetCurrentCartUseCase.Input, GetCurrentCartUseCase.Output> {
    class Input
    data class Output(val result: Flow<OrderModel?>)
}
