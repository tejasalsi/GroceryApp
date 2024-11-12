package com.emart.groceriesstore.domain.usecases

import com.emart.groceriesstore.data.database.entities.LineItem

interface AddToCartUseCase: SuspendUseCase<AddToCartUseCase.Input, AddToCartUseCase.Output> {
    class Input (val lineItem: LineItem)

    class Output
}
