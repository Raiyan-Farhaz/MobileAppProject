package com.example.myuniclubs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myuniclubs.ui.navigation.AppNavGraph
import com.example.myuniclubs.ui.theme.MyUniClubsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyUniClubsTheme {
                AppNavGraph()   // 🔥 This launches your full navigation (Login → Register → Home)
            }
        }
    }
}
