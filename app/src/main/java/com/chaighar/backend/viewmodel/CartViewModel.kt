package com.chaighar.backend.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.chaighar.R
import com.chaighar.domain.model.ProductModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class CartViewModel: ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    private val emptyCart = mutableStateOf<List<ProductModel>>(emptyList())
    val cartItems: State<List<ProductModel>> = emptyCart

    fun addToCart(
        productId: Int, name: String, description: String, price: Double, onComplete: (Boolean) -> Unit
    ) {
        val userId = auth.currentUser?.uid ?: return onComplete(false)
        val docId = "${userId}_${productId}"

        val cartData = hashMapOf(
            "userId" to userId, "productId" to productId, "name" to name, "description" to description, "price" to price, "quantity" to 1
        )
        db.collection("cart").document(docId).set(cartData).addOnCompleteListener { onComplete(it.isSuccessful) }
    }

    fun getCartItems() {

        val currentUser = auth.currentUser
        val userId = currentUser?.uid

        db.collection("cart").whereEqualTo("userId", userId).addSnapshotListener { snapshot, error ->
            if (error != null || snapshot == null) return@addSnapshotListener

            val items = snapshot.documents.mapNotNull { doc ->
                try {
                    val id = (doc.getLong("productId") ?: 0L).toInt()
                    val name = doc.getString("name") ?: ""
                    val description = doc.getString("description") ?: ""
                    val price = doc.getDouble("price") ?: 0.0
                    val quantity = doc.getLong("quantity")?.toInt() ?: 1

                    val imageRes = when (id) {
                        1 -> R.drawable.doodh_patti
                        2 -> R.drawable.kashmiri_chai
                        3 -> R.drawable.masala_chai
                        4 -> R.drawable.karak_chai
                        5 -> R.drawable.iran_chai
                        6 -> R.drawable.sulmani_chai
                        else -> R.drawable.chaicupintro
                    }

                    ProductModel(
                        id = id,
                        name = name,
                        description = description,
                        imageRes = imageRes,
                        price = price,
                        quantity = quantity
                    )

                }catch (e: Exception) { null }
            }
            emptyCart.value = items
        }
    }

    fun updateQuantity(productId: Int, newQuantity: Int) {
        val userId = auth.currentUser?.uid ?: return
        val docId = "${userId}_${productId}"

        if (newQuantity !in 1..20) return

        db.collection("cart").document(docId).update("quantity", newQuantity)
    }

    fun removeFromCart(productId: Int, onComplete: (Boolean) -> Unit) {
        val userId = auth.currentUser?.uid ?: return onComplete(false)
        val docId = "${userId}_${productId}"

        db.collection("cart").document(docId).delete().addOnCompleteListener { onComplete(it.isSuccessful) }
    }
}