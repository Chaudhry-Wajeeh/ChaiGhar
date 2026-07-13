package com.chaighar.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object WelcomeScreen: Routes()

    @Serializable
    object HomeScreen: Routes()

    @Serializable
    data class DetailedScreen(val productId: Int): Routes()

    @Serializable
    object CartScreen: Routes()

    @Serializable
    object ProfileScreen: Routes()

    @Serializable
    object FavoriteScreen: Routes()

    @Serializable
    object LoginScreen: Routes()

    @Serializable
    object SignUpScreen: Routes()

    @Serializable
    object PersonalInfo: Routes()

    @Serializable
    object AccountInfo: Routes()
}