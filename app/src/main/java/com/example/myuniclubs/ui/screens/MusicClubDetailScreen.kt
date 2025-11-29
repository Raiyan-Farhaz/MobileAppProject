package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myuniclubs.ui.theme.BlueButton
import com.example.myuniclubs.ui.theme.BlueHeader
import com.example.myuniclubs.ui.theme.DarkText
import com.example.myuniclubs.ui.theme.LightGrayField
import com.example.myuniclubs.ui.theme.OrangeBackground

@Composable
fun MusicClubDetailScreen(
    onBack: () -> Unit      // from NavGraph: navController.popBackStack()
) {
    Column(modifier = Modifier.fillMaxSize()) {

        // ------- HEADER -------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(BlueHeader),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Football Club Details",
                fontWeight = FontWeight.Bold,
                color = DarkText,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // ------- ORANGE CONTENT -------
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(OrangeBackground)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // fake image box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(LightGrayField)
            )

            Spacer(Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = LightGrayField),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("TUS Football Club", fontWeight = FontWeight.Bold, color = DarkText)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Join the TUS Football club to learn, play and compete.",
                        color = DarkText
                    )

                    Spacer(Modifier.height(12.dp))

                    Button(
                        onClick = { /* TODO: contact/join */ },
                        colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text("Contact / Join Club", color = Color.White)
                    }

                    Spacer(Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("Events", fontWeight = FontWeight.SemiBold)
                        Text("Announcement", fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }

        // ------- BOTTOM NAV (INLINE, NO BottomNavDetail) -------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(BlueHeader),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onBack, // go back “home”
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Home", color = Color.White)
                }

                Button(
                    onClick = { /* TODO: navigate to profile if you want */ },
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Profile", color = Color.White)
                }
            }
        }
    }
}
