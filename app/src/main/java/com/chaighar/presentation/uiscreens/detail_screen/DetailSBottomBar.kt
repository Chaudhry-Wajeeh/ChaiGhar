package com.chaighar.presentation.uiscreens.detail_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaighar.presentation.theme.IvoryWhite
import com.chaighar.presentation.theme.LightBrown
import com.chaighar.presentation.ui_components.AppMessage

@Composable
fun DetailSBottomBar() {
    var showCartDialog by remember { mutableStateOf(false) }

    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Column {
                Text(text = "Price", fontSize = 16.sp)

                Spacer(modifier = Modifier.height(6.dp))

                Text(text = "Rs: 49.99", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.width(50.dp))

            Button(
                onClick = { showCartDialog = true }
                , modifier = Modifier.weight(1f).height(56.dp)
                    .align(alignment = Alignment.CenterVertically),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown, contentColor = IvoryWhite
                )
            ) {
                Text(
                    text = "Add to Cart", fontSize = 20.sp, fontWeight = FontWeight.SemiBold
                )
            }

            AppMessage(
                show = showCartDialog, title = "Added to Cart",
                message = "Item has been added to your cart.",
                onDismiss = { showCartDialog = false }
            )
        }
    }
}