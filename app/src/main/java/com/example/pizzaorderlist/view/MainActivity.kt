package com.example.pizzaorderlist.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzaorderlist.R
import com.example.pizzaorderlist.di.DI
import com.example.pizzaorderlist.model.Pizza
import com.example.pizzaorderlist.model.UIState
import com.example.pizzaorderlist.util.LARGE
import com.example.pizzaorderlist.util.MEDIUM
import com.example.pizzaorderlist.util.SMALL

class MainActivity : AppCompatActivity() {

    private val TAG = "--AKR--"
    private val viewModel by lazy { DI.provideViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureObservers()
    }

    private fun configureObservers()  {
        viewModel.uiState.observe(this) {
            when(it) {
                is UIState.LOADING -> {
                    // show loading spinner
                    Log.d(TAG, "Loading...")
                }
                is UIState.ERROR -> {
                    // show error text
                    Log.d(TAG, it.msg)
                }
                is UIState.SUCCESS -> {
                    calculateTotal(it.pizzas.order)
                }
            }
        }
    }

    private fun calculateTotal(list: List<Pizza>) {
        var total = 0

        for(i in list) {
            when(i.size) {
                SMALL -> {
                    total += 4
                }
                MEDIUM -> {
                    total += 8
                }
                LARGE -> {
                    total += 15
                }
            }
        }
        Log.d(TAG, "Total is ${total}€")
    }
}