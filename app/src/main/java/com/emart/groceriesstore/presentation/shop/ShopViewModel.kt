package com.emart.groceriesstore.presentation.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emart.groceriesstore.data.database.entities.LineItem
import com.emart.groceriesstore.data.database.entities.Order
import com.emart.groceriesstore.domain.models.OrderModel
import com.emart.groceriesstore.domain.models.ProductModel
import com.emart.groceriesstore.domain.usecases.AddToCartUseCase
import com.emart.groceriesstore.domain.usecases.CreateNewOrderUseCase
import com.emart.groceriesstore.domain.usecases.GetCurrentCartUseCase
import com.emart.groceriesstore.domain.usecases.GetProductsListUseCase
import com.emart.groceriesstore.utilities.OrderStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val STOP_TIMEOUT = 5000L

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val getProductsListUseCase: GetProductsListUseCase,
    private val getCurrentCartUseCase: GetCurrentCartUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    private val createNewOrderUseCase: CreateNewOrderUseCase
) : ViewModel() {
    val productList: StateFlow<List<ProductModel>> =
        getProductLists()?.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(STOP_TIMEOUT),
            emptyList()
        )!!

    private val _navigateToSelectedProperty = MutableStateFlow<ProductModel?>(null)
    val navigateToSelectedProperty: StateFlow<ProductModel?>
        get() = _navigateToSelectedProperty.asStateFlow()

    var currentCart: StateFlow<OrderModel?> = getCurrentCart()
        ?.stateIn(viewModelScope, SharingStarted.WhileSubscribed(STOP_TIMEOUT), null)!!

    init {
        viewModelScope.launch {
            currentCart.collect {}
        }
    }

    fun displayProductDetails(product: ProductModel) {
        _navigateToSelectedProperty.value = product
    }

    fun displayProductDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    private fun getProductLists(): Flow<List<ProductModel>>? {
        var res: Flow<List<ProductModel>>? = null
        viewModelScope.launch {
            res = getProductsListUseCase(GetProductsListUseCase.Input()).result
        }
        return res
    }

    private fun getCurrentCart(): Flow<OrderModel?>? {
        var res: Flow<OrderModel?>? = null
        viewModelScope.launch {
            res = getCurrentCartUseCase(GetCurrentCartUseCase.Input()).result
        }
        return res
    }

    fun addToCart(product: ProductModel) {
        if (currentCart.value != null) {
            // Add to cart
            val cartId = currentCart.value!!.id
            viewModelScope.launch {
                addToCartUseCase(
                    AddToCartUseCase.Input(
                        LineItem(
                            productId = product.id,
                            orderId = cartId,
                            quantity = 1,
                            subtotal = product.price!!
                        )
                    )
                )
            }
        } else {
            val id = UUID.randomUUID().toString()
            viewModelScope.launch {
                createNewOrderUseCase(
                    CreateNewOrderUseCase.Input(
                        Order(
                            id = id,
                            status = OrderStatus.IN_CART.value,
                            address = ""
                        )
                    )
                )
                addToCartUseCase(
                    AddToCartUseCase.Input(
                        LineItem(
                            productId = product.id,
                            orderId = id,
                            quantity = 1,
                            subtotal = product.price!!
                        )
                    )
                )
            }
        }
    }
}
