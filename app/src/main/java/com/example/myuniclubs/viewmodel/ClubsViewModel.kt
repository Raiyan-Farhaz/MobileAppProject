package com.example.myuniclubs.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myuniclubs.data.AppDatabase
import com.example.myuniclubs.data.ClubEntity
import com.example.myuniclubs.data.ClubRepository
import kotlinx.coroutines.launch

class ClubsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ClubRepository

    init {
        val dao = AppDatabase.getDatabase(application).clubDao()
        repository = ClubRepository(dao)
    }

    fun insertClub(club: ClubEntity) {
        viewModelScope.launch {
            repository.insertClub(club)
        }
    }

    fun deleteClub(club: ClubEntity) {
        viewModelScope.launch {
            repository.deleteClub(club)
        }
    }

    fun getAllClubs(onResult: (List<ClubEntity>) -> Unit) {
        viewModelScope.launch {
            val data = repository.getAllClubs()
            onResult(data)
        }
    }

    fun updateSavedStatus(clubId: Int, isSaved: Boolean) {
        viewModelScope.launch {
            repository.updateSavedStatus(clubId, isSaved)
        }
    }
}
