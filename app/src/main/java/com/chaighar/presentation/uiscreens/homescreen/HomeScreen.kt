package com.chaighar.presentation.uiscreens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.ui_components.BottomNavbar


@Composable
fun HomeScreen(navController: NavController) {
    val location = "Kuri Rd, Shakrial"
    Scaffold(
        bottomBar = { BottomNavbar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(1f/3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
                .padding(start = 15.dp, end = 10.dp, top = 12.dp, bottom = 10.dp)
        ) {
            Text(text = "Location", color = Color.Gray, fontSize = 16.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable(onClick = {})
            ) {
                Text(
                    text = location + " ",
                    color = Color.White, fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null, tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(35.dp))

            SearchBar()

            Spacer(modifier = Modifier.height(15.dp))

            val products = listOf(
                ProductModel(id = 1, name = "Doodh Patti", description = "Garam doodh main patti", price = 50.0, imageRes = R.drawable.doodh_patti),
                ProductModel(id = 2, name = "Kashmiri Chai", description = "Pink Chai with dry fruits", price = 50.0, imageRes = R.drawable.kashmiri_chai),
                ProductModel(id = 3, name = "Masala Chai", description = "Masla tarka in Chai", price = 50.0, imageRes = R.drawable.masala_chai),
                ProductModel(id = 4, name = "Karak Chai", description = "Garhi chai", price = 50.0, imageRes = R.drawable.karak_chai),
                ProductModel(id = 5, name = "Irani Chai", description = "Karhi khoya chai", price = 50.0, imageRes = R.drawable.iran_chai),
                ProductModel(id = 6, name = "Sulaimani Chai", description = "Bagair doodh ka kawa chai", price = 50.0, imageRes = R.drawable.sulmani_chai),
            )

            ProductsGrid(products = products) {

                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(R.drawable.promo_h_banner_1), contentDescription = "Promo Home Banner",
                    modifier = Modifier.clip(shape = RoundedCornerShape(
                        topStart = 16.dp, topEnd = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp
                    ))
                )

                Spacer(modifier = Modifier.height(20.dp))
                HomeCategories()
            }
        }
    }
}