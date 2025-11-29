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
fun ChessClubDetailScreen(onBack: () -> Unit) {

    Column(Modifier.fillMaxSize()) {

        // ------- HEADER -------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(BlueHeader),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Chess Club Details",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // ------- ORANGE CONTENT -------
        Column(
            modifier = Modifier
                .weight(1f)
                .background(OrangeBackground)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.chess),
                contentDescription = null,
                modifier = Modifier.size(140.dp)
            )

            Spacer(Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(LightGrayField)
            ) {
                Column(Modifier.padding(16.dp)) {

                    Text("Chess Club", fontWeight = FontWeight.Bold)
                    Text("Challenge your mind. Weekly meetings available!")

                    Spacer(Modifier.height(10.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(BlueButton),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text("Join Club", color = Color.White)
                    }

                    Spacer(Modifier.height(16.dp))

                    // ⭐ NEW SIMPLE DESCRIPTION (NO ERRORS)
                    Text(
                        "The Chess Club welcomes all students, from beginners to advanced players.",
                        color = DarkText
                    )
                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Meet classmates, seniors and juniors who share the same love for strategy.",
                        color = DarkText
                    )
                    Spacer(Modifier.height(6.dp))

                    Text(
                        "We learn together, play together and grow together like a family.",
                        color = DarkText
                    )
                    Spacer(Modifier.height(6.dp))

                    Text(
                        "If you enjoy thinking ahead and challenging yourself, this club is the perfect place.",
                        color = DarkText
                    )
                }
            }
        }

        // ------- BOTTOM NAV -------
        BottomNavDetailBar(onBack)
    }
}

@Composable
private fun BottomNavDetailBar(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(BlueHeader),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onBack,
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


