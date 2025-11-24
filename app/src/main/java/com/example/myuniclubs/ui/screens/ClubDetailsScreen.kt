package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myuniclubs.data.ClubEntity

@Composable
fun ClubDetailScreen(
    club: ClubEntity,
    onBack: () -> Unit,
    onSaveToggle: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(club.name, style = MaterialTheme.typography.headlineLarge)
        Text(club.category, style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(20.dp))

        Text(club.description)

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = { onSaveToggle(!club.saved) }
        ) {
            Text(if (club.saved) "Unsave" else "Save")
        }

        Spacer(Modifier.height(20.dp))

        OutlinedButton(onClick = onBack) {
            Text("Back")
        }
    }
}



