package com.chaighar.uiscreens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chaighar.R
import com.chaighar.model.ProductModel

@Composable
fun HomeCategories() {
    val categories = listOf(
        "All Chais", "Doodh Patti", "Kashmiri", "Masala Chai", "Karak Chai", "Irani Chai", "Sulamani"
    )
    var selectedCategory by remember { mutableStateOf(categories.first()) }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories) { category ->
            CategoryChip(
                text = category,
                isSelected = category == selectedCategory,
                onSelected = {selectedCategory = category}
            )
        }
    }
}


public val products = listOf(
    ProductModel(id = 1, name = "Doodh Patti", description = "Garam doodh main patti", price = 50.0, imageRes = R.drawable.doodh_patti),
    ProductModel(id = 2, name = "Kashmiri Chai", description = "Pink Chai with dry fruits", price = 50.0, imageRes = R.drawable.kashmiri_chai),
    ProductModel(id = 3, name = "Masala Chai", description = "Masla tarka in Chai", price = 50.0, imageRes = R.drawable.masala_chai),
    ProductModel(id = 4, name = "Karak Chai", description = "Garhi chai", price = 50.0, imageRes = R.drawable.karak_chai),
    ProductModel(id = 5, name = "Irani Chai", description = "Karhi khoya chai", price = 50.0, imageRes = R.drawable.iran_chai),
    ProductModel(id = 6, name = "Sulaimani Chai", description = "Bagair doodh ka kawa chai", price = 50.0, imageRes = R.drawable.sulmani_chai),
)