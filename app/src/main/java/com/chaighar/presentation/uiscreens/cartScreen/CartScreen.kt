package com.chaighar.presentation.uiscreens.cartScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.LightBrown
import com.chaighar.presentation.ui_components.BottomNavbar


@Composable
fun CartScreen(navController: NavController) {
    val cartProducts = listOf(
        ProductModel(id = 1, name = "Doodh Patti", description = "Garam doodh main patti", price = 40.0, imageRes = R.drawable.doodh_patti),
        ProductModel(id = 2, name = "Kashmiri Chai", description = "Pink Chai with dry fruits", price = 60.0, imageRes = R.drawable.kashmiri_chai),
        ProductModel(id = 3, name = "Masala Chai", description = "Masla tarka in Chai", price = 50.0, imageRes = R.drawable.masala_chai),
    )
    var amount by remember { mutableStateOf(150.0) }
    var deliveryFee by remember { mutableStateOf(20.0) }
    var total by remember { mutableStateOf(amount + deliveryFee) }

    Scaffold(
        topBar = {CartSTopBar(navController = navController)},
        bottomBar = { BottomNavbar(navController = navController) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(innerPadding)
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
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Payment Summary", style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Price", fontSize = 18.sp)
                    Text(text = "PKR $amount", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Delivery Fee", fontSize = 18.sp)
                    Text(text = "PKR $deliveryFee", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(4.dp))

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth() ,thickness = 1.dp, color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Total", fontSize = 18.sp)
                    Text(text = "PKR $total", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(20.dp))

                PaymentSelectionCard(total = total)
            }
        }
    }
}