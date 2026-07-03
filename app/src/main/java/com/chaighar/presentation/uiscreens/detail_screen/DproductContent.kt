package com.chaighar.presentation.uiscreens.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chaighar.R
import com.chaighar.domain.model.ProductModel
import com.chaighar.presentation.theme.CreamBeige
import com.chaighar.presentation.theme.GrayLight
import com.chaighar.presentation.theme.IvoryWhite

@Composable
fun DproductContent(product: ProductModel, innerPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize().padding(10.dp).padding(paddingValues = innerPadding)
    ) {
        Image(
            painter = painterResource(id = product.imageRes), contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth().height(250.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = product.name, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row {

            Text(
                text = "Dark / Hot", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = CreamBeige
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.default_bean), contentDescription = null,
                modifier = Modifier
                    .background( color = IvoryWhite, shape = RoundedCornerShape(10.dp) )
                    .size(35.dp).padding(5.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp, color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Description", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = product.description, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = CreamBeige
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Size", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        var selectedSizeText by remember { mutableStateOf("M") }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {

            listOf("S", "M", "L").forEach { size ->
                SelectSizeChip(
                    sizeText = size, selected = selectedSizeText == size,
                    onClick = { selectedSizeText = size},
                    modifier = Modifier.weight(1f).height(46.dp)
                )
            }
        }
    }
}