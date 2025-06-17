package com.fauzana0133.assesmentmobpro3.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fauzana0133.assesmentmobpro3.viewmodel.ItemViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: ItemViewModel) {
    val itemViewModel: ItemViewModel = viewModel

    Scaffold(modifier = Modifier.fillMaxSize()) {
        ItemListScreen(viewModel = itemViewModel)
    }
}
