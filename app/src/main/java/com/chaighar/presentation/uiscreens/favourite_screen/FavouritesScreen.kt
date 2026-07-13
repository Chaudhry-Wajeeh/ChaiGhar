package com.chaighar.presentation.uiscreens.favourite_screen

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.backend.viewmodel.FavViewModel
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.ui_components.BottomNavbar


@Composable
fun FavouritesScreen(navController: NavController) {

    val context = LocalContext.current
    val favViewModel: FavViewModel = viewModel()

    LaunchedEffect(Unit) {
        favViewModel.getFavourite()
    }
    val favouriteItems by favViewModel.favourites
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
            items(favouriteItems) { product ->
                FavouriteItemCard(product = product) {
                    favViewModel.removeFavorite(product.id){
                    if (!it) {
                        Toast.makeText(context, "Could not remove item", Toast.LENGTH_SHORT).show()
                    }
                }
                }
            }
        }
    }
}