package com.chaighar.presentation.uiscreens.favourite_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.ui_components.BottomNavbar


@Composable
fun FavouritesScreen(navController: NavController) {

    var favouriteItems by rememberSaveable {
        mutableStateOf(listOf(
            ProductModel(id = 1, name = "Doodh Patti", description = "Garam doodh main patti", price = 40.0, imageRes = R.drawable.doodh_patti),
            ProductModel(id = 2, name = "Kashmiri Chai", description = "Pink Chai with dry fruits", price = 60.0, imageRes = R.drawable.kashmiri_chai),
            ProductModel(id = 3, name = "Masala Chai", description = "Masla tarka in Chai", price = 50.0, imageRes = R.drawable.masala_chai),
            )
        )
    }
    Scaffold(
        topBar = { FavouriteSTopBar() },
        bottomBar = { BottomNavbar(navController = navController, "Favorite") }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            item {
                favouriteItems.forEach { product ->
                    FavouriteItemCard(
                        product = product, onRemove = { favouriteItems = favouriteItems - product}
                    )
                }
            }
        }
    }
}