package com.fauzana0133.assesmentmobpro3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.fauzana0133.assesmentmobpro3.screen.MainScreen
import com.fauzana0133.assesmentmobpro3.ui.theme.Assesmentmobpro3Theme
import com.fauzana0133.assesmentmobpro3.viewmodel.ItemViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assesmentmobpro3Theme {
                MainScreen(viewModel = ItemViewModel()) // Hanya memanggil screen utama
            }
        }
    }
}
