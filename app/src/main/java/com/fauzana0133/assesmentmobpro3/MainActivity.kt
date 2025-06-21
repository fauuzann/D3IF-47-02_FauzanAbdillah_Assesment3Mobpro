package com.fauzana0133.assesmentmobpro3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fauzana0133.assesmentmobpro3.screen.LoginScreen
import com.fauzana0133.assesmentmobpro3.ui.theme.Assesmentmobpro3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assesmentmobpro3Theme {
                LoginScreen(onLoginSuccess = {
                    println("✅ Login Berhasil - Callback terpanggil")
                })
            }
        }
    }
}
