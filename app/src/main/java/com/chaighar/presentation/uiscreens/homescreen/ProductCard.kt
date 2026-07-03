package com.chaighar.presentation.uiscreens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.GrayLight
import com.chaighar.presentation.theme.LightBrown

@Composable
fun ProductCard(
    product: ProductModel, modifier: Modifier = Modifier, navController: NavController
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .clickable{ navController.navigate(Routes.DetailedScreen(product.id) ) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(7.dp)) {
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
            ) {
                Image(
                    painter = painterResource(product.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )

                Box(
                    modifier = Modifier.align(alignment = Alignment.TopEnd)
                        .padding(5.dp)
                        .clickable(onClick = {})
                        .background(
                            color = GrayLight.copy(alpha = 0.7f), shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_heart),
                        contentDescription = "Add to Favorite",
                        tint = LightBrown,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name.toString(),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.Black, fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = product.description.toString(),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Gray, fontWeight = FontWeight.Normal
                ),
                maxLines = 1, overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.price.toString(),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier.background(
                        color = LightBrown, shape = RoundedCornerShape(12.dp)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add, contentDescription = "Add to Cart",
                        tint = Color.White
                    )
                }
            }
        }
    }
}