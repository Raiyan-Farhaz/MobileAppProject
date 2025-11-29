package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myuniclubs.R
import com.example.myuniclubs.ui.theme.*

@Composable
fun MusicClubDetailScreen(
    onBack: () -> Unit
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
                text = "Music Club Details",
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

            // REAL IMAGE
            Image(
                painter = painterResource(id = R.drawable.music),
                contentDescription = null,
                modifier = Modifier.size(140.dp)
            )

            Spacer(Modifier.height(16.dp))

            // ------- CLUB CARD -------
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = LightGrayField),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(Modifier.padding(16.dp)) {

                    Text("TUS Music Club", fontWeight = FontWeight.Bold, color = DarkText)
                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Join the TUS Music Club to learn instruments, sing, perform, and compose.",
                        color = DarkText
                    )

                    Spacer(Modifier.height(12.dp))

                    Button(
                        onClick = { /* future join */ },
                        colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text("Contact / Join Club", color = Color.White)
                    }

                    Spacer(Modifier.height(16.dp))

                    // ⭐ NEW DESCRIPTION PARAGRAPH (SAFE TEXT LINES)
                    Text(
                        "If you love music—whether it’s singing, playing, or producing—",
                        color = DarkText
                    )
                    Text(
                        "the Music Club is the perfect place to express your creativity.",
                        color = DarkText
                    )
                    Spacer(Modifier.height(6.dp))

                    Text(
                        "You’ll meet other students who share the same passion as you,",
                        color = DarkText
                    )
                    Text(
                        "from beginners just starting out to experienced musicians.",
                        color = DarkText
                    )
                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Together we learn, jam, perform, and support each other like a family.",
                        color = DarkText
                    )
                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Whether you want to join a band, sing in events, or produce beats,",
                        color = DarkText
                    )
                    Text(
                        "there’s a place for you here in the TUS Music Club.",
                        color = DarkText
                    )

                    Spacer(Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("Events", fontWeight = FontWeight.SemiBold)
                        Text("Announcements", fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }

        // ------- BOTTOM NAV -------
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
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Home", color = Color.White)
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Profile", color = Color.White)
                }
            }
        }
    }
}

