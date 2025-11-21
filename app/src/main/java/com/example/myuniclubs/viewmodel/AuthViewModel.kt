package com.example.myuniclubs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    private val repo = AuthRepository()

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    fun login(email: String, password: String) {
        repo.login(email, password).addOnCompleteListener { task ->
            _isLoggedIn.value = task.isSuccessful
        }
    }

    fun register(email: String, password: String) {
        repo.register(email, password).addOnCompleteListener { task ->
            _isLoggedIn.value = task.isSuccessful
        }
    }
}
