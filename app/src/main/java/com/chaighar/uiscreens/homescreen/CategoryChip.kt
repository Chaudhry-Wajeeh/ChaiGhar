package com.chaighar.uiscreens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaighar.ui.theme.GrayLight
import com.chaighar.ui.theme.LightBrown

@Composable
fun CategoryChip(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(120.dp).height(40.dp)
            .clip(RoundedCornerShape(6.dp))
            .clickable{onSelected}
            .background( color = if (isSelected) {LightBrown} else { GrayLight.copy(alpha = 0.7f) } ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, maxLines = 1,
            color = if (isSelected) {Color.White} else {Color.Black})
    }
}