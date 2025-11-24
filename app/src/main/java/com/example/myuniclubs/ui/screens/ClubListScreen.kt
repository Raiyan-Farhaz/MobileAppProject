package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myuniclubs.data.ClubEntity

@Composable
fun ClubListScreen(
    clubs: List<ClubEntity>,
    onClubClick: (ClubEntity) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("All Clubs", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        clubs.forEach { club ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onClubClick(club) }
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(club.name, style = MaterialTheme.typography.titleLarge)
                    Text(club.category)
                }
            }
        }
    }
}


