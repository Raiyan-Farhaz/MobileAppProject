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

    // EMAIL from Firebase Auth
    val currentUserEmail: String?
        get() = firebaseAuth.currentUser?.email

    // NAME from Firestore
    private val _currentUserName = MutableStateFlow("Student")
    val currentUserName = _currentUserName.asStateFlow()

    // ---------------------------------------------------
    // PUBLIC — Load user name from Firestore
    // ---------------------------------------------------
    fun loadUserName() {
        viewModelScope.launch {
            val uid = firebaseAuth.currentUser?.uid ?: return@launch
            val name = repo.getUserName(uid)
            _currentUserName.value = name ?: "Student"
        }
    }

    // ---------------------------------------------------
    // REGISTER USER
    // ---------------------------------------------------
    fun registerWithName(name: String, email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            val result = repo.registerWithName(name, email, password)

            if (result.isSuccess) {

                //  Firebase refresh the logged-in user
                firebaseAuth.currentUser?.reload()

                //  load the name safely
                loadUserName()

                //  NOW set success
                _authState.value = AuthState.Success

            } else {
                _authState.value =
                    AuthState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
            }
        }
    }

    // ---------------------------------------------------
    // LOGIN USER
    // ---------------------------------------------------
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            val result = repo.login(email, password)

            if (result.isSuccess) {
                loadUserName()  // ⬅ Fetch name after successful login
                _authState.value = AuthState.Success
            } else {
                _authState.value =
                    AuthState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
            }
        }
    }

    fun isLoggedIn(): Boolean = repo.isLoggedIn()
}
