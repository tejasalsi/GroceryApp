package com.emart.groceriesstore.presentation.delivery

data class DeliveryModel(
    val name: String,
    val phoneNumber: String,
    val street: String,
    val district: String,
    val province: String
)