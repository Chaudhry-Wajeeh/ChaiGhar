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
import com.chaighar.backend.viewmodel.CartViewModel
import com.chaighar.backend.viewmodel.FavViewModel
import com.chaighar.backend.viewmodel.ProductsViewModel
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.ui_components.AppMessage


@Composable
fun DetailedScreen(productId: Int, navController: NavController) {

    val context = LocalContext.current
    val favViewModel: FavViewModel = viewModel()
    var showFavDialog by remember { mutableStateOf(false) }
    val cartViewModel: CartViewModel = viewModel()
    var showCartDialog by remember { mutableStateOf(false) }
    val productsViewModel: ProductsViewModel = viewModel()
    val selectedProduct = productsViewModel.productsList.find { it.id == productId }

    if (selectedProduct == null) {
        Text(text = "Product not found!", color = Color.Red)
        return
    }
    Scaffold(
        topBar = {DetailScreenTBar(navController = navController, onFavoriteClick = {
            favViewModel.addFavourite(
                productId = selectedProduct.id, name = selectedProduct.name, description = selectedProduct.description
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
        bottomBar = {
            DetailSBottomBar(onCartClick =
                {
                    cartViewModel.addToCart(
                        productId = selectedProduct.id, name = selectedProduct.name,
                        description = selectedProduct.description, price = selectedProduct.price
                    ) {
                        if (it) {
                            showCartDialog = true
                        }else {
                            Toast.makeText(context, "Failed to add to Cart", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            )
        }
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
    AppMessage(
        show = showCartDialog, title = "Added to Cart",
        message = "Item has been added to your cart.",
        onDismiss = { showCartDialog = false }
    )
}