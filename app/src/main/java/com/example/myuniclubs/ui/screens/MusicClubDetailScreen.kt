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
    Column(Modifier.fillMaxSize()) {

        // Header
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

        // Body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(OrangeBackground)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.music),
                contentDescription = null,
                modifier = Modifier.size(140.dp)
            )

            Spacer(Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(LightGrayField),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Music Club", fontWeight = FontWeight.Bold)
                    Text("Join us to explore instruments, bands, and more!")
                    Spacer(Modifier.height(10.dp))
                    Button(onClick = { }, colors = ButtonDefaults.buttonColors(BlueButton)) {
                        Text("Join Club", color = Color.White)
                    }
                }
            }
        }

        // Bottom Nav
        BottomNavDetail(onBack)
    }
}


