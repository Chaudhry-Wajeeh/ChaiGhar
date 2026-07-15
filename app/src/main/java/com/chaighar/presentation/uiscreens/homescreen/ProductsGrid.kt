package com.chaighar.presentation.uiscreens.homescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.chaighar.domain.model.ProductModel


@Composable
fun ProductsGrid(
    products: List<ProductModel>,
    navController: NavController,
    onFavoriteClick: (ProductModel) -> Unit,
    onCartClick: (ProductModel) -> Unit,
    topContent: @Composable () -> Unit

) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            topContent()
        }
        items(products.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ProductCard(
                    product = rowItems[0],
                    modifier = Modifier.weight(1f),
                    navController = navController,
                    onFavoriteClick = onFavoriteClick,
                    onCartClick = onCartClick
                )
                if (rowItems.size == 2) {
                    ProductCard(
                        product = rowItems[1],
                        modifier = Modifier.weight(1f),
                        navController = navController,
                        onFavoriteClick = onFavoriteClick,
                        onCartClick = onCartClick
                    )
                }else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}