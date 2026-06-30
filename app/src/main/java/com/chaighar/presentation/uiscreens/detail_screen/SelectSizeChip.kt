package com.chaighar.presentation.uiscreens.detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaighar.presentation.theme.ChocolateGray
import com.chaighar.presentation.theme.GrayLight
import com.chaighar.presentation.theme.IvoryWhite
import com.chaighar.presentation.theme.LightBrown

@Composable
fun SelectSizeChip(sizeText: String, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .background(
                color = if(selected) IvoryWhite else Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .height(46.dp)
            .border(
                width = 1.dp,
                color = if(selected) Color(0xFFC67C4E)  else GrayLight,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = sizeText, fontSize = 16.sp, fontWeight = FontWeight.SemiBold,
            color = if (selected) LightBrown  else ChocolateGray
        )
    }
}