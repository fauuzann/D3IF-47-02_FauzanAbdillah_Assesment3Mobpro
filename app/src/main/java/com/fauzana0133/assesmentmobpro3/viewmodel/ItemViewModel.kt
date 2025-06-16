package com.fauzana0133.assesmentmobpro3.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fauzana0133.assesmentmobpro3.data.ApiClient
import com.fauzana0133.assesmentmobpro3.data.Item
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    var itemList by mutableStateOf(listOf<Item>())
    var isLoading by mutableStateOf(false)

    init {
        fetchItems()
    }

    fun fetchItems() {
        viewModelScope.launch {
            isLoading = true
            try {
                itemList = ApiClient.ApiClient.retrofit.getItems()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }
}