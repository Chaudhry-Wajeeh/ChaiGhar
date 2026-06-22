package com.chaighar.uiscreens.homescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaighar.R
import com.chaighar.ui.theme.ChaiBrown
import com.chaighar.ui.theme.IvoryWhite

@SuppressLint("InvalidColorHexValue")
@Preview
@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.regular_outline_search),
                    contentDescription = "Search",
                    modifier = Modifier.size(26.dp), tint = Color.White
                )
            } ,
            placeholder = { Text(text = "Search Chai Types", fontSize = 23.sp, color = Color.Gray) },
            shape = RoundedCornerShape(
                topStart = 16.dp, topEnd = 0.dp, bottomStart = 16.dp, bottomEnd = 0.dp
            ),
            singleLine = true,
            modifier = Modifier.padding(start = 4.dp).weight(1f).height(59.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFF2A2A2A),focusedContainerColor = Color(0xFF28242),
                focusedTextColor = Color.White, unfocusedTextColor = Color.White,
                cursorColor = Color.LightGray
                )
        )

        Spacer(modifier = Modifier.width(5.dp))

        IconButton(
            onClick = {},
            modifier = Modifier.background(
                color = ChaiBrown,
                shape = RoundedCornerShape(
                    topStart = 0.dp, topEnd = 16.dp,
                    bottomStart = 0.dp, bottomEnd = 16.dp)
                )
                .padding(end = 10.dp).size(width = 40.dp,height = 57.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.regular_outline_filter),
                contentDescription = "Filer", tint = IvoryWhite
            )
        }
    }
}