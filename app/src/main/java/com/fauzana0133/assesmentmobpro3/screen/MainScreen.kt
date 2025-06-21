package com.fauzana0133.assesmentmobpro3.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.room.parser.Section
import com.fauzana0133.assesmentmobpro3.viewmodel.ItemViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: ItemViewModel) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Section.Text("🏠 Kamu berhasil masuk ke MainScreen!")
    }

    LaunchedEffect(Unit) {
        println("✅ MAINSCREEN DIBUKA")
    }
}


