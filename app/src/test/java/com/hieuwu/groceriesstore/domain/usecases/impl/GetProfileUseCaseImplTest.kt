package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.UserRepository
import com.emart.groceriesstore.domain.models.UserModel
import com.emart.groceriesstore.domain.usecases.GetProfileUseCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)

class GetProfileUseCaseImplTest {

    @Mock
    lateinit var mockedUserRepository: UserRepository

    private lateinit var testee: GetProfileUseCase

    @Before
    fun setUp() {
        testee = GetProfileUseCaseImpl(
            userRepository = mockedUserRepository
        )
    }

    @Test
    fun givenUserAvailable_whenExecute_thenReturnCorrectValue() {
        whenever(mockedUserRepository.getCurrentUser()).thenReturn(flow {
            UserModel(
                id = "",
                name = "",
                email = "",
                phone = "",
                address = "",
                isOrderCreatedNotiEnabled = true,
                isPromotionNotiEnabled = true,
                isDataRefreshedNotiEnabled = true
            )
        })
        runBlocking {
            val result = testee(GetProfileUseCase.Input())

            result.result.collect {
                assertEquals("", it?.id)
                assertTrue(it!!.isDataRefreshedNotiEnabled)
                assertTrue(it.isOrderCreatedNotiEnabled)
                assertTrue(it.isPromotionNotiEnabled)
            }
        }
    }


    @Test
    fun givenUserUnavailable_whenExecute_thenReturnCorrectValue() {
        whenever(mockedUserRepository.getCurrentUser()).thenReturn(flow {
            null
        })

        runBlocking {
            val result = testee(GetProfileUseCase.Input())
            result.result.collect {
                assertNull(it)
            }
        }
    }

}