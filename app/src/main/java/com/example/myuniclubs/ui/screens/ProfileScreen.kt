package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myuniclubs.ui.theme.*

@Composable
fun ProfileScreen(
    userName: String,
    userEmail: String,
    onNavigateToSaved: () -> Unit,
    onLogout: () -> Unit,
    onNavigateHome: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {

        // ---------------- HEADER ----------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(BlueHeader),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "My TUS Profile",
                fontWeight = FontWeight.Bold,
                color = DarkText,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // ---------------- ORANGE BODY ----------------
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(OrangeBackground)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Profile Picture Placeholder
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(Color.LightGray, CircleShape)
            )

            Spacer(Modifier.height(16.dp))

            // NAME
            Text(
                text = userName,
                fontWeight = FontWeight.Bold,
                color = DarkText,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(6.dp))

            // EMAIL
            Text(
                text = userEmail,
                color = DarkText
            )

            Spacer(Modifier.height(24.dp))

            // BUTTONS
            ProfileButton("My Saved Clubs", onNavigateToSaved)
            Spacer(Modifier.height(12.dp))

            ProfileButton("Edit Profile") {}
            Spacer(Modifier.height(12.dp))

            ProfileButton("Settings and Preferences") {}
            Spacer(Modifier.height(25.dp))

            // LOGOUT
            Button(
                onClick = onLogout,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Log Out", color = Color.White)
            }
        }

        // ---------------- BOTTOM NAV ----------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(BlueHeader),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                // HOME BUTTON
                Button(
                    onClick = onNavigateHome,
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Home", color = Color.White)
                }

                // PROFILE BUTTON
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Profile", color = Color.White)
                }
            }
        }
    }
}

@Composable
private fun ProfileButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = LightGrayField),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text, color = DarkText)
    }
}
