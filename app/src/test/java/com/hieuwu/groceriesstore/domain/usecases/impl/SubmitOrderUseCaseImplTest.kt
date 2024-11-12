package com.emart.groceriesstore.domain.usecases.impl

import com.emart.groceriesstore.data.repository.OrderRepository
import com.emart.groceriesstore.domain.models.OrderModel
import com.emart.groceriesstore.domain.usecases.SubmitOrderUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class SubmitOrderUseCaseImplTest {

    @Mock
    lateinit var mockedOrderRepository: OrderRepository
    private lateinit var testee: SubmitOrderUseCase

    @Before
    fun setUp() {
        testee = SubmitOrderUseCaseImpl(
            orderRepository = mockedOrderRepository,
            ioDispatcher = Dispatchers.IO
        )
    }

    @Test
    fun whenExecute_thenSubmitOrderSuccessfully() {
        runBlocking {
            whenever(mockedOrderRepository.sendOrderToServer(any())).thenReturn(true)
            testee(
                SubmitOrderUseCase.Input(
                    order = OrderModel(
                        lineItemList = mutableListOf()
                    )
                )
            )

            verify(mockedOrderRepository).sendOrderToServer(
                OrderModel(
                    lineItemList = mutableListOf()
                )
            )
        }
    }

}