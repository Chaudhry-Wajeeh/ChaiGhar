package com.chaighar.presentation.uiscreens.detail_screen

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.backend.viewmodel.FavViewModel
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.ui_components.AppMessage


@Composable
fun DetailedScreen(productId: Int, navController: NavController) {

    val context = LocalContext.current
    val favViewModel: FavViewModel = viewModel()
    var showFavDialog by remember { mutableStateOf(false) }

    val products = listOf(
        ProductModel(id = 1, name = "Doodh Patti", description = "Garam doodh main patti", price = 40.0, imageRes = R.drawable.doodh_patti),
        ProductModel(id = 2, name = "Kashmiri Chai", description = "Pink Chai with dry fruits", price = 60.0, imageRes = R.drawable.kashmiri_chai),
        ProductModel(id = 3, name = "Masala Chai", description = "Masla tarka in Chai", price = 50.0, imageRes = R.drawable.masala_chai),
        ProductModel(id = 4, name = "Karak Chai", description = "Garhi chai", price = 50.0, imageRes = R.drawable.karak_chai),
        ProductModel(id = 5, name = "Irani Chai", description = "Karhi khoya chai", price = 50.0, imageRes = R.drawable.iran_chai),
        ProductModel(id = 6, name = "Sulaimani Chai", description = "Bagair doodh ka kawa chai", price = 50.0, imageRes = R.drawable.sulmani_chai),
    )

    val selectedProduct = products.find { it.id == productId }

    if (selectedProduct == null) {
        Text(text = "Product not found!", color = Color.Red)
        return
    }
    Scaffold(
        topBar = {DetailScreenTBar(navController = navController, onFavoriteClick = {
            favViewModel.addFavourite(
                productId = selectedProduct.id,
                name = selectedProduct.name,
                description = selectedProduct.description
            ) {
                if (it) {
                    showFavDialog = true
                } else {
                    Toast.makeText(context, "Failed to add to Favourites", Toast.LENGTH_SHORT).show()
                }
            }
        }
        )
                 },
        bottomBar = {DetailSBottomBar()}
    ) { innerPadding ->
        LazyColumn {
            item {

                  DproductContent( product = selectedProduct, innerPadding = innerPadding)
            }
        }
    }

    AppMessage(
        show = showFavDialog, title = "Added to Favourites",
        message = "Item has been added to Favourites.",
        onDismiss = { showFavDialog = false }
    )
}