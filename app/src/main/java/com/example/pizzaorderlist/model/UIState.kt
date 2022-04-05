package com.example.pizzaorderlist.model

sealed class UIState {
    object LOADING : UIState()
    data class ERROR(val msg: String) : UIState()
    data class SUCCESS(val pizzas: PizzaResponse) : UIState()
}