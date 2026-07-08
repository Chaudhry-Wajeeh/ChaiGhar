package com.chaighar.presentation.uiscreens.cartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.theme.GrayLight
import com.chaighar.presentation.theme.LightBrown


@Composable
fun CartItemCart(product: ProductModel) {

    var quantity by rememberSaveable { mutableStateOf(1) }

    Card(
        modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = GrayLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = "Masala Chai",
                modifier = Modifier.size(70.dp).clip(RoundedCornerShape(10.dp))
            )

            Column(
                modifier = Modifier.weight(1f).padding(start = 12.dp)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.DarkGray
                    )
                )

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(end = 6.dp)
            ) {
                IconButton(
                    onClick = { quantity-- }, enabled = quantity > 1,
                    modifier = Modifier.background(
                        color = LightBrown.copy(alpha = 0.15f), shape = CircleShape
                    ).size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove, contentDescription = "Decrease",
                        tint = LightBrown
                    )
                }

                Text(
                    text = quantity.toString(), style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )

                IconButton(
                    onClick = { quantity++ },enabled = quantity < 20,
                    modifier = Modifier.background(
                        color = LightBrown.copy(alpha = 0.15f), shape = CircleShape
                    ).size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add, contentDescription = "Increase",
                        tint = LightBrown
                    )
                }
            }
        }
    }
}