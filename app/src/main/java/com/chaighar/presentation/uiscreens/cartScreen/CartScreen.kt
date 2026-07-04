package com.chaighar.presentation.uiscreens.cartScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaighar.R
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.theme.LightBrown


@Preview
@Composable
fun CartScreen() {
    val cartProducts = listOf(
        ProductModel(id = 1, name = "Doodh Patti", description = "Garam doodh main patti", price = 50.0, imageRes = R.drawable.doodh_patti),
        ProductModel(id = 2, name = "Kashmiri Chai", description = "Pink Chai with dry fruits", price = 50.0, imageRes = R.drawable.kashmiri_chai),
        ProductModel(id = 3, name = "Masala Chai", description = "Masla tarka in Chai", price = 50.0, imageRes = R.drawable.masala_chai),
    )

    Scaffold(
        topBar = {CartSTopBar()}
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(16.dp).padding(innerPadding)
        ) {
            item {
                Row {
                    Text(
                        text = "Delivery", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                cartProducts.forEach { product ->
                    CartItemCart(product)
                }
            }
        }
    }
}