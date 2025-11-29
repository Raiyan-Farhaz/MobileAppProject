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
fun SportsClubDetailsScreen(onBack: () -> Unit) {

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
                text = "Gaming Club Details",
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
                painter = painterResource(id = R.drawable.sports),
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

                    Text("Gaming Club", fontWeight = FontWeight.Bold)
                    Text("Competitive gaming, events & tournaments.")

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

                    // ⭐ NEW PARAGRAPH ABOUT OUTDOOR SPORTS & CLUB FEEL
                    Text("The Gaming Club brings together players who enjoy teamwork, strategy, and friendly competition.")
                    Spacer(Modifier.height(6.dp))

                    Text("Along with digital gaming, we participate in outdoor sports like cricket, football, rugby, tennis, and basketball.")
                    Spacer(Modifier.height(6.dp))

                    Text("Members get a chance to meet other passionate students, test their skills, and grow together as a community.")
                    Spacer(Modifier.height(6.dp))

                    Text("Whether you're a casual player or competitive gamer, you'll find teammates, friends, and a fun environment waiting for you.")
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
            ) { Text("Home", color = Color.White) }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                shape = RoundedCornerShape(20.dp)
            ) { Text("Profile", color = Color.White) }
        }
    }
}
