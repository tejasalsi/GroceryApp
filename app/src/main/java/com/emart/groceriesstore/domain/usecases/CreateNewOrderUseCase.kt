package com.emart.groceriesstore.domain.usecases

import com.emart.groceriesstore.data.database.entities.Order

interface CreateNewOrderUseCase :
    SuspendUseCase<CreateNewOrderUseCase.Input, CreateNewOrderUseCase.Output> {
    class Input(val order: Order)

    class Output(result: Unit)
}
