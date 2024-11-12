package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.UserRepository
import com.emart.groceriesstore.di.IoDispatcher
import com.emart.groceriesstore.domain.usecases.UpdateProfileUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UpdateProfileUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
) :
    UpdateProfileUseCase {
    override suspend fun invoke(input: UpdateProfileUseCase.Input): UpdateProfileUseCase.Output {
        userRepository.updateUserProfile(
            input.userId, input.name, input.email, input.phone, input.address
        )
        return UpdateProfileUseCase.Output()
    }
}