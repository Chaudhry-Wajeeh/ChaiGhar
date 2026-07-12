package com.chaighar.presentation.uiscreens.profile_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chaighar.presentation.navigation.Routes
import com.chaighar.presentation.theme.LightBrown

@Composable
fun ProfileSCard(
    navController: NavController,
    cardData: ProfileCardModel = ProfileCardModel(
        icon = Icons.Default.Home, text = "Home Screen", onClick = { navController.navigate(Routes.HomeScreen) }
    )
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { cardData.onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = cardData.icon,
            contentDescription = cardData.icon.name,
            tint = LightBrown,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = cardData.text, fontSize = 22.sp, color = Color.DarkGray, maxLines = 1, overflow = TextOverflow.Ellipsis
        )
    }
}