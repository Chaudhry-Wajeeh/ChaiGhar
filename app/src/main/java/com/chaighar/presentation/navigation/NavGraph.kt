package com.chaighar.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.chaighar.presentation.uiscreens.cartScreen.CartScreen
import com.chaighar.presentation.uiscreens.detail_screen.DetailedScreen
import com.chaighar.presentation.uiscreens.favourite_screen.FavouritesScreen
import com.chaighar.presentation.uiscreens.homescreen.HomeScreen
import com.chaighar.presentation.uiscreens.profile_screen.ProfileScreen
import com.chaighar.presentation.uiscreens.signup_screens.LoginScreen
import com.chaighar.presentation.uiscreens.signup_screens.SignUpScreen
import com.chaighar.presentation.uiscreens.welcomeS.WelcomeScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val currentUser = FirebaseAuth.getInstance().currentUser
    val startDestination = if (currentUser != null) { Routes.HomeScreen }else { Routes.WelcomeScreen }


    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController = navController)
        }

        composable<Routes.SignUpScreen> {
            SignUpScreen(navController = navController)
        }

        composable<Routes.LoginScreen> {
            LoginScreen(navController = navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController = navController)
        }

        composable<Routes.DetailedScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailedScreen>()
            DetailedScreen(productId = args.productId, navController = navController)
        }

        composable<Routes.CartScreen> {
            CartScreen(navController = navController)
        }

        composable<Routes.FavoriteScreen> {
            FavouritesScreen(navController = navController)
        }

        composable<Routes.ProfileScreen> {
            ProfileScreen(navController = navController)
        }
    }
}