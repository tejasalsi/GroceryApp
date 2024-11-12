package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.UserRepository
import com.emart.groceriesstore.di.IoDispatcher
import com.emart.groceriesstore.domain.usecases.SignOutUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignOutUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) :
    SignOutUseCase {
    override suspend fun invoke(input: SignOutUseCase.Input): SignOutUseCase.Output {
        return withContext(ioDispatcher) {
            userRepository.clearUser()
            SignOutUseCase.Output()
        }
    }
}