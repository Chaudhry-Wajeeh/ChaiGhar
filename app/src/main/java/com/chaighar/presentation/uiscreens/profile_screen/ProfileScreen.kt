package com.chaighar.presentation.uiscreens.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.GrayLight
import com.chaighar.presentation.theme.IvoryWhite
import com.chaighar.presentation.theme.LightBrown
import com.chaighar.presentation.theme.LightGraySuper
import com.chaighar.presentation.ui_components.BottomNavbar

@Composable
fun ProfileScreen(navController: NavController) {
    val address = "Kuri Road,\nShakrial Rawalpindi,\nPunjab - 44001"

    Scaffold(
        bottomBar = { BottomNavbar(navController = navController, "Profile") }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth().height(140.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 110.dp, bottomEnd = 110.dp))
                .background(color = IvoryWhite)
        ) { }
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp).clip(CircleShape)
                        .background(color = LightBrown.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person, contentDescription = "Profile Picture",
                        modifier = Modifier.size(70.dp),
                        tint = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Chudhary Wajeeh", style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "myapp@gmail.com", style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Address", style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = address, style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(40.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = GrayLight.copy(.7f))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .clickable { navController.navigate(Routes.CartScreen) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Cart",
                            tint = LightBrown,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))

                        Text(text = "Cart", fontSize = 22.sp, color = Color.DarkGray)
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    HorizontalDivider(
                        thickness = 1.dp, color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 2.dp).fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .clickable { navController.navigate(Routes.FavoriteScreen) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Fav",
                            tint = LightBrown,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))

                        Text(text = "Favourites", fontSize = 22.sp, color = Color.DarkGray)
                    }
                }
            }
        }
    }
}