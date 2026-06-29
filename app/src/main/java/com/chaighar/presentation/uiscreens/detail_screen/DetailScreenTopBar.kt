package com.chaighar.presentation.uiscreens.detail_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chaighar.R
import com.chaighar.presentation.theme.IvoryWhite
import com.chaighar.presentation.theme.LightGraySuper

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailScreenTBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Details", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                        },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = IvoryWhite),
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_heart),
                        contentDescription = "Add to Favorite",
                        modifier = Modifier.padding(end = 10.dp)
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_arrow_right),
                        contentDescription = "Back",
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            )
        }
    ) {}
}