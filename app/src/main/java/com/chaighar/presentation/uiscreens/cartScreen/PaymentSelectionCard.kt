package com.chaighar.presentation.uiscreens.cartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaighar.R
import com.chaighar.presentation.theme.LightBrown

@Composable
fun PaymentSelectionCard(total: Double) {

    var expanded by remember { mutableStateOf(false) }
    var selectedMode by rememberSaveable { mutableStateOf("Online Payment") }
    val paymentModes = listOf("Cash on Delivery", "Online Payment")

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(
                            id =
                                if (selectedMode == "Online Payment") R.drawable.mobile_banking
                                else R.drawable.wallet
                        ),
                        contentDescription = "Payment Method", modifier = Modifier.size(35.dp),
                        tint = LightBrown
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Column() {
                        Text(
                            text = selectedMode,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Pkr $total",
                            style = MaterialTheme.typography.bodyMedium,
                            color = LightBrown
                        )
                    }
                }
                Box() {
                    Icon(
                        painter = painterResource(id = R.drawable.regular_outline_arrow_down),
                        contentDescription = "Change Payment Method",
                        modifier = Modifier.size(20.dp).clickable(onClick = { expanded = true })
                    )

                    DropdownMenu(
                        expanded = expanded, onDismissRequest = { expanded = false }
                    ) {
                        paymentModes.forEach { mode ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = mode, style = MaterialTheme.typography.bodyLarge
                                    )
                                },
                                onClick = {
                                    selectedMode = mode; expanded = false
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(
                                            id =
                                                if (mode == "Online Payment") R.drawable.mobile_banking
                                                else R.drawable.wallet
                                        ),
                                        contentDescription = "Icon Changing", tint = LightBrown,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                modifier = Modifier.background(
                                    color = if (selectedMode == mode) LightBrown.copy(alpha = 0.2f) else Color.Transparent
                                )
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*navController.navigate(Routes.HomeScreen)*/ },
                colors = ButtonDefaults.buttonColors(LightBrown),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.5.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Place Order", color = Color.White,
                    fontSize = 18.sp, modifier = Modifier.padding(horizontal = 15.dp)
                )
            }
        }
    }
}