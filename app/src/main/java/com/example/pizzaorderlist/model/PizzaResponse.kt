package com.example.pizzaorderlist.model

data class PizzaResponse(
    val order: List<Pizza>
)

data class Pizza(
    val type: String,
    val size: String,
    val toppings: List<String>?,
    val sauce: List<String>?
)
