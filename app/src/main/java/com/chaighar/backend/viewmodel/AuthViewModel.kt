package com.chaighar.backend.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest

class AuthViewModel: ViewModel() {

    private val auth = FirebaseAuth.getInstance()

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
}