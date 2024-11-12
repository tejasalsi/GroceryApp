package com.emart.groceriesstore.domain.usecases

import com.emart.groceriesstore.domain.models.OrderModel

interface SubmitOrderUseCase : SuspendUseCase<SubmitOrderUseCase.Input, SubmitOrderUseCase.Output> {
    class Input(val order: OrderModel)
    data class Output(val result: Boolean)
}
