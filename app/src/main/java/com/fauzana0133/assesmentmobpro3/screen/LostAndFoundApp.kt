package com.fauzana0133.assesmentmobpro3.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fauzana0133.assesmentmobpro3.viewmodel.ItemViewModel

@Composable
fun LostAndFoundApp(startDestination: String) {
    val navController = rememberNavController()
    val viewModel = ItemViewModel()

    NavHost(navController = navController, startDestination = startDestination) {
        composable("login") {
            LoginScreen {
                navController.navigate("main") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }
        composable("main") {
            MainScreen(viewModel = viewModel)
        }
    }
}
