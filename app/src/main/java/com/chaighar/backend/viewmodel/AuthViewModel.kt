package com.chaighar.backend.viewmodel

import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore

class AuthViewModel: ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    fun login(email: String, password: String, onResult:(Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            onResult(it.isSuccessful)
        }
    }

    fun signUp(name: String ,email: String, password: String, onResult:(Boolean) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                val profileUpdates = userProfileChangeRequest { displayName = name }

                user?.updateProfile(profileUpdates)?.addOnCompleteListener {
                    onResult(it.isSuccessful)
                }
            }else {
                onResult(false)
            }
        }
    }

    fun deleteAccount(onComplete: (Boolean, String?) -> Unit) {

        val currentUser = auth.currentUser?: return onComplete(false, "No user found logged in")
        val userId = currentUser.uid
        val cartQuery = db.collection("cart").whereEqualTo("userId", userId).get()
        val favoritesQuery = db.collection("favourites").whereEqualTo("userId", userId).get()

        Tasks.whenAllComplete(cartQuery, favoritesQuery).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val batch = db.batch()

                val cartSnapshot = cartQuery.result
                if (cartSnapshot != null) {
                    for (document in cartSnapshot.documents) {
                        batch.delete(document.reference)
                    }
                }

                val favoritesSnapshot = favoritesQuery.result
                if (favoritesSnapshot != null) {
                    for (document in favoritesSnapshot.documents) {
                        batch.delete(document.reference)
                    }
                }

                batch.commit().addOnCompleteListener { batchTask ->
                    if (batchTask.isSuccessful) {
                        currentUser.delete().addOnCompleteListener {
                            if (it.isSuccessful) {
                                onComplete(true, null)
                            } else {
                                val authException = it.exception?.message?: "Failed to delete Account"
                                onComplete(false, authException)
                            }
                        }
                    }else {
                        val batchException = batchTask.exception?.message ?: "Failed to delete Account Data"
                        onComplete(false, batchException)
                    }
                }
            }else {
                onComplete(false, "Failed to retrieve account data")
            }
        }
    }
}