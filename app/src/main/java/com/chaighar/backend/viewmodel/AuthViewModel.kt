package com.chaighar.backend.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel: ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    fun login(email: String, password: String, onResult:(Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            onResult(it.isSuccessful)
        }
    }

    fun signUp(email: String, password: String, onResult:(Boolean) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            onResult(it.isSuccessful)
        }
    }
}