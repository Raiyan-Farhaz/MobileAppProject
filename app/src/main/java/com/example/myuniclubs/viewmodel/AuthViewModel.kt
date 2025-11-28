package com.example.myuniclubs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myuniclubs.data.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    object Success : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel : ViewModel() {

    private val repo = AuthRepository()
    private val firebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState = _authState.asStateFlow()

    // 🔥 EXPOSE CURRENT USER EMAIL
    val currentUserEmail: String?
        get() = firebaseAuth.currentUser?.email

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val result = repo.login(email, password)
            _authState.value =
                if (result.isSuccess) AuthState.Success
                else AuthState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val result = repo.register(email, password)
            _authState.value =
                if (result.isSuccess) AuthState.Success
                else AuthState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
        }
    }

    fun isLoggedIn(): Boolean = repo.isLoggedIn()
}
