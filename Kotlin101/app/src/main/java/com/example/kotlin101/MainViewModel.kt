package com.example.kotlin101

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
//MainViewModel récupère les données
class MainViewModel : ViewModel() {
    var countryListResponse: List<Country> by mutableStateOf(listOf())

    fun getCountryList() {
        viewModelScope.launch {
            val apiService = ApiService.RetrofitApi.getInstance().create(ApiService::class.java)
            try {
                apiService.getAll().body()?.let { countries ->
                    val sortedCountries: List<Country> = countries.sortedBy { it.name.common }
                    countryListResponse = sortedCountries
                }
            }
            //gestion des erreurs
            catch (e: Exception) {
                println("ERROR:" + e.message)
            }
        }
    }
}