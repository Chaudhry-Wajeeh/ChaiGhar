package com.chaighar.backend.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.chaighar.R
import com.chaighar.domain.model.ProductModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FavViewModel: ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    private val emptyFavs = mutableStateOf<List<ProductModel>>(emptyList())
    val favourites: State<List<ProductModel>> = emptyFavs

    fun addFavourite(
        productId: Int, name: String, description: String, onComplete: (Boolean) -> Unit
    ) {
        val userId = auth.currentUser?.uid ?: return onComplete(false)
        val docId = "${userId}_${productId}"

        val favData = hashMapOf(
            "userId" to userId, "productId" to productId, "name" to name, "description" to description
        )

        db.collection("favourites").document(docId).set(favData).addOnCompleteListener {
            onComplete(it.isSuccessful)
        }
    }


    fun getFavourite() {
        val currentUser = auth.currentUser
        val userId = currentUser?.uid

        db.collection("favourites").whereEqualTo("userId", userId).addSnapshotListener { snapshot, error ->
            if (error != null && snapshot == null) { return@addSnapshotListener }

            val items = snapshot!!.documents.mapNotNull { doc ->
                try {
                    val id = (doc.getLong("productId") ?: 0L).toInt()
                    val name = doc.getString("name") ?: ""
                    val description = doc.getString("description") ?: ""
                    val price = doc.getDouble("price") ?: 0.0

                    val imageRes = when (id) {
                        1 -> R.drawable.doodh_patti
                        2 -> R.drawable.kashmiri_chai
                        3 -> R.drawable.masala_chai
                        4 -> R.drawable.karak_chai
                        5 -> R.drawable.iran_chai
                        6 -> R.drawable.sulmani_chai
                        else -> R.drawable.chaicupintro
                    }

                    ProductModel(id = id, name = name, description = description, imageRes = imageRes, price = price)

                }catch (e: Exception) { null }
            }
            emptyFavs.value = items
        }
    }


    fun removeFavorite(productId: Int, onComplete: (Boolean) -> Unit) {

        val userId = auth.currentUser?.uid ?: return onComplete(false)
        val docId = "${userId}_${productId}"

        db.collection("favourites").document(docId).delete().addOnCompleteListener {
            onComplete(it.isSuccessful)
        }
    }
}