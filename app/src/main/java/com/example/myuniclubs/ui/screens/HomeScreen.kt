package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myuniclubs.data.ClubEntity

@Composable
fun HomeScreen() {

    // Fake hardcoded clubs for Sprint 2
    val sampleClubs = listOf(
        ClubEntity(name = "Music Club", category = "Arts", description = "Love music? Join us!"),
        ClubEntity(name = "Gaming Club", category = "Entertainment", description = "Gamers unite!"),
        ClubEntity(name = "Chess Club", category = "Strategy", description = "Challenge your mind."),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Welcome to MyUniClubs",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        sampleClubs.forEach { club ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(club.name, style = MaterialTheme.typography.titleLarge)
                    Text(club.category, style = MaterialTheme.typography.bodyMedium)
                    Text(club.description, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}


