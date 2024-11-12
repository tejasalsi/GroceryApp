package com.emart.groceriesstore.domain.usecases

interface RemoveMealFromPlanUseCase :
    SuspendUseCase<RemoveMealFromPlanUseCase.Input, RemoveMealFromPlanUseCase.Output> {
    class Input(val id: String)
    sealed class Output {
        object Success: Output()
        object Failure: Output()
    }
}