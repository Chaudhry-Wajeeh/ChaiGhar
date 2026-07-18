package com.chaighar.backend.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.chaighar.R
import com.chaighar.domain.model.ProductFBModel
import com.chaighar.domain.model.ProductModel
import com.google.firebase.firestore.FirebaseFirestore

class ProductsViewModel: ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    val productsList = mutableStateListOf<ProductModel>()

    private val productHardcoredList = listOf(
        ProductFBModel(id = 1, name = "Doodh Patti", description = "Garam doodh main patti", price = 40.0, imageRes = R.drawable.doodh_patti),
        ProductFBModel(id = 2, name = "Kashmiri Chai", description = "Pink Chai with dry fruits", price = 80.0, imageRes = R.drawable.kashmiri_chai),
        ProductFBModel(id = 3, name = "Masala Chai", description = "Masla tarka in Chai", price = 60.0, imageRes = R.drawable.masala_chai),
        ProductFBModel(id = 4, name = "Karak Chai", description = "Garhi chai", price = 50.0, imageRes = R.drawable.karak_chai),
        ProductFBModel(id = 5, name = "Irani Chai", description = "Karhi khoya chai", price = 70.0, imageRes = R.drawable.iran_chai),
        ProductFBModel(id = 6, name = "Sulaimani Chai", description = "Bagair doodh ka kawa chai", price = 40.0, imageRes = R.drawable.sulmani_chai)
    )

    init {
        //uploadProducts()
        fetchProductsFromDB()
    }

    fun uploadProducts() {
        val collection = db.collection("products")

        for (product in productHardcoredList) {
            collection.document(product.id.toString()).set(product).addOnCompleteListener { it.isSuccessful }
        }
    }

    fun fetchProductsFromDB() {
        db.collection("products").get().addOnSuccessListener { snapshot ->
            productsList.clear()

            for (document in snapshot.documents) {
                val id = document.getLong("id")?.toInt() ?: 0
                val name = document.getString("name") ?: ""
                val description = document.getString("description") ?: ""
                val price = document.getDouble("price") ?: 0.0
                val imageRes = document.getLong("imageRes")?.toInt() ?: 0

                /*val imageRes = when (id) {
                    1 -> R.drawable.doodh_patti
                    2 -> R.drawable.kashmiri_chai
                    3 -> R.drawable.masala_chai
                    4 -> R.drawable.karak_chai
                    5 -> R.drawable.iran_chai
                    6 -> R.drawable.sulmani_chai
                    else -> R.drawable.doodh_patti
                }*/

                val product = ProductModel(
                    id = id,
                    name = name,
                    description = description,
                    price = price,
                    imageRes = imageRes
                )

                productsList.add(product)
            }
        }
    }
}