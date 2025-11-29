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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(BlueHeader),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Sport Club Details",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )
        }

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
                    Text("Competitive games, events & tournaments!")
                    Spacer(Modifier.height(10.dp))
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(BlueButton)) {
                        Text("Join Club", color = Color.White)
                    }
                }
            }
        }

        BottomNavDetail(onBack)
    }
}