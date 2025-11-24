package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myuniclubs.data.ClubEntity

@Composable
fun SavedClubsScreen(
    savedClubs: List<ClubEntity>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Saved Clubs", style = MaterialTheme.typography.headlineMedium)

        if (savedClubs.isEmpty()) {
            Spacer(Modifier.height(50.dp))
            Text("No saved clubs yet.")
        } else {
            savedClubs.forEach { club ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(club.name, style = MaterialTheme.typography.titleLarge)
                        Text(club.category)
                    }
                }
            }
        }
    }
}


