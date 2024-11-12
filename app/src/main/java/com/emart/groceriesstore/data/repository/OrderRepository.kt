package com.emart.groceriesstore.data.repository

import com.emart.groceriesstore.data.database.entities.LineItem
import com.emart.groceriesstore.data.database.entities.Order
import com.emart.groceriesstore.domain.models.OrderModel
import com.emart.groceriesstore.utilities.OrderStatus
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun createOrUpdate(order: Order)
    suspend fun addLineItem(lineItem: LineItem)
    fun getOneOrderByStatus(status: OrderStatus): Flow<OrderModel?>
    suspend fun sendOrderToServer(order: OrderModel): Boolean

    suspend fun getOrders(): List<OrderModel>
}
