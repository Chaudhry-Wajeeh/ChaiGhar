package com.chaighar.presentation.uiscreens.profile_screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileCardDivider() {
    Spacer(modifier = Modifier.height(9.dp))
    HorizontalDivider(
        thickness = 1.dp, color = Color.Gray,
        modifier = Modifier
            .padding(horizontal = 2.dp)
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(9.dp))
}