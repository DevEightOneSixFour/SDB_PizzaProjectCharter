package com.example.pizzaorderlist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pizzaorderlist.api.ApiRepositoryImpl
import com.example.pizzaorderlist.api.ApiService
import com.example.pizzaorderlist.util.BASE_URL
import com.example.pizzaorderlist.viewmodel.PizzaViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DI {
    private val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun provideRepositoryImpl() = ApiRepositoryImpl(api)

    fun provideViewModel(storeOwner: ViewModelStoreOwner) =
        ViewModelProvider(storeOwner,
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
               return PizzaViewModel(provideRepositoryImpl()) as T
            }
        })[PizzaViewModel::class.java]
}