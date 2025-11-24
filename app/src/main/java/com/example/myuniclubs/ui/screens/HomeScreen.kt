package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myuniclubs.data.ClubEntity

@Composable
fun HomeScreen(
    onNavigateToClubs: () -> Unit,
    onNavigateToSaved: () -> Unit,
    onNavigateToProfile: () -> Unit
) {

    // Existing sample clubs (Sprint 2 preview)
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

        Spacer(Modifier.height(20.dp))

        // ---------------- TOP BUTTONS ----------------

        Button(
            onClick = onNavigateToClubs,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View All Clubs")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = onNavigateToSaved,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Saved Clubs")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = onNavigateToProfile,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Profile")
        }

        Spacer(Modifier.height(20.dp))

        // ---------------- SAMPLE PREVIEW (Sprint 2) ----------------
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
