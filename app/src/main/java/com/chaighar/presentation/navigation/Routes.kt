package com.chaighar.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object WelcomeScreen: Routes()

    @Serializable
    object HomeScreen: Routes()

    @Serializable
    data class DetailedScreen(val productId: Int): Routes()


}