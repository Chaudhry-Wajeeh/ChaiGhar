package com.chaighar.backend.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FavViewModel: ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

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

    fun removeFavorite(productId: Int, onComplete: (Boolean) -> Unit) {

        val userId = auth.currentUser?.uid ?: return onComplete(false)
        val docId = "${userId}_${productId}"

        db.collection("favourites").document(docId).delete().addOnCompleteListener {
            onComplete(it.isSuccessful)
        }
    }
}