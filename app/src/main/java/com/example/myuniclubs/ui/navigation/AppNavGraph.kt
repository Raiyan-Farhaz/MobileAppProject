package com.example.myuniclubs.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myuniclubs.ui.screens.*
import com.example.myuniclubs.data.ClubEntity
import com.google.firebase.auth.FirebaseAuth

// Temporary sample clubs for list/preview
val sampleClubs = listOf(
    ClubEntity(1, "Music Club", "Arts", "Love music? Join us!"),
    ClubEntity(2, "Gaming Club", "Entertainment", "Gamers unite!"),
    ClubEntity(3, "Chess Club", "Strategy", "Challenge your mind.")
)

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // ---------------- LOGIN ----------------
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("home") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }

        // ---------------- REGISTER ----------------
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate("home") },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }

        // ---------------- HOME ----------------
        composable("home") {
            HomeScreen(
                onNavigateToClubs = { navController.navigate("clubs") },
                onNavigateToSaved = { navController.navigate("saved") },
                onNavigateToProfile = { navController.navigate("profile") },
                onClubClick = { clubId ->
                    when (clubId) {
                        1 -> navController.navigate("musicDetail")
                        2 -> navController.navigate("gamingDetail")
                        3 -> navController.navigate("chessDetail")
                    }
                }
            )
        }

        // ---------------- CLUB LIST ----------------
        composable("clubs") {
            ClubListScreen(
                clubs = sampleClubs,
                onClubClick = { club ->
                    when (club.id) {
                        1 -> navController.navigate("musicDetail")
                        2 -> navController.navigate("gamingDetail")
                        3 -> navController.navigate("chessDetail")
                    }
                }
            )
        }

        // ---------------- INDIVIDUAL CLUB DETAIL PAGES ----------------
        composable("musicDetail") {
            MusicClubDetailScreen(onBack = { navController.popBackStack() })
        }

        composable("gamingDetail") {
            SportsClubDetailsScreen(onBack = { navController.popBackStack() })
        }

        composable("chessDetail") {
            ChessClubDetailScreen(onBack = { navController.popBackStack() })
        }

        // ---------------- SAVED CLUBS ----------------
        composable("saved") {
            SavedClubsScreen(savedClubs = sampleClubs.filter { it.saved })
        }

        // ---------------- PROFILE ----------------
        composable("profile") {

            val user = FirebaseAuth.getInstance().currentUser
            val email = user?.email ?: "Unknown Email"
            val name = user?.displayName ?: "Unknown User"

            ProfileScreen(
                userName = name,
                userEmail = email,
                onNavigateToSaved = { navController.navigate("saved") },
                onLogout = {
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                onNavigateHome = { navController.navigate("home") } // NEW
            )
        }
    }
}
