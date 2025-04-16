package com.example.ARSENAL8.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.ARSENAL8.repository.AuthRepository

class AuthviewModel() : ViewModel() {
    private val repository: AuthRepository = AuthRepository()

    var isRegistered by mutableStateOf<Boolean?>(null)
        private set

    fun register(email: String, password: String) {
        repository.register(email, password) { success ->
            isRegistered = success
        }
    }
}