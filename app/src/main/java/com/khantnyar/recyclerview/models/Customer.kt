package com.khantnyar.recyclerview.models

data class Customer(val id: Int, val name: String)

data class OrderCustomer(val id: Int, val orderId: Int, val customerId: Int)

