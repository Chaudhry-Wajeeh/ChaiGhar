package com.chaighar.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.chaighar.presentation.uiscreens.detail_screen.DetailedScreen
import com.chaighar.presentation.uiscreens.homescreen.HomeScreen
import com.chaighar.presentation.uiscreens.welcomeS.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Routes.WelcomeScreen
    ) {
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController = navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController = navController)
        }

        composable<Routes.DetailedScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailedScreen>()
            DetailedScreen(productId = args.productId, navController = navController)
        }
    }
}