package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

    // ⭐ EASY NEW FEATURE – LOCAL DARK MODE TOGGLE
    var darkMode by remember { mutableStateOf(false) }

    val backgroundColor = if (darkMode) Color.DarkGray else OrangeBackground
    val textColor = if (darkMode) Color.White else DarkText

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
                color = textColor,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // ---------------- BODY ----------------
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(backgroundColor)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Profile placeholder
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(Color.LightGray, CircleShape)
            )

            Spacer(Modifier.height(16.dp))

            Text(userName, fontWeight = FontWeight.Bold, color = textColor)
            Text(userEmail, color = textColor)

            Spacer(Modifier.height(24.dp))

            // ⭐ NEW DARK MODE SWITCH
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Dark Mode",
                    color = textColor,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = darkMode,
                    onCheckedChange = { darkMode = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = BlueButton
                    )
                )
            }

            Spacer(Modifier.height(24.dp))

            ProfileButton("My Saved Clubs", onNavigateToSaved)
            Spacer(Modifier.height(12.dp))

            ProfileButton("Edit Profile") {}
            Spacer(Modifier.height(12.dp))

            ProfileButton("Settings and Preferences") {}

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = onLogout,
                modifier = Modifier
                    .fillMaxWidth()
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

                Button(
                    onClick = onNavigateHome,
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Home", color = Color.White)
                }

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
