package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myuniclubs.data.ClubEntity
import com.example.myuniclubs.ui.theme.*
import com.example.myuniclubs.viewmodel.AuthViewModel

@Composable
fun HomeScreen(
    onNavigateToClubs: () -> Unit,
    onNavigateToSaved: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onClubClick: (Int) -> Unit,
    viewModel: AuthViewModel = viewModel()
) {
    val userEmail = viewModel.currentUserEmail ?: "User"

    //  Collect name from StateFlow
    val userName = viewModel.currentUserName.collectAsState().value ?: "Student"

    val sampleClubs = listOf(
        ClubEntity(1, "Music Club", "Arts", "Love music? Join us!"),
        ClubEntity(2, "Gaming Club", "Entertainment", "Gamers unite!"),
        ClubEntity(3, "Chess Club", "Strategy", "Challenge your mind.")
    )

    Column(modifier = Modifier.fillMaxSize()) {

        // ---------------- HEADER ----------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(BlueHeader),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Explore TUS Clubs",
                    fontWeight = FontWeight.Bold,
                    color = DarkText,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Welcome, $userName",
                    color = DarkText,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        // ---------------- MAIN ORANGE AREA ----------------
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(OrangeBackground)
                .padding(16.dp)
        ) {

            sampleClubs.forEach { club ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onClubClick(club.id) }
                        .padding(vertical = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = LightGrayField),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(club.name, fontWeight = FontWeight.Bold, color = DarkText)
                        Text(club.category, color = DarkText)
                        Text(club.description, color = DarkText)
                    }
                }
            }

            TextButton(
                onClick = {},
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("See more..", color = DarkText)
            }
        }

        // ---------------- BOTTOM NAV BAR ----------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(BlueHeader),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = onNavigateToClubs,
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) { Text("All Clubs", color = Color.White) }

                Button(
                    onClick = onNavigateToSaved,
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) { Text("Saved Clubs", color = Color.White) }

                Button(
                    onClick = onNavigateToProfile,
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) { Text("Profile", color = Color.White) }
            }
        }
    }
}
