package com.example.myuniclubs.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myuniclubs.ui.screens.*
import com.example.myuniclubs.viewmodel.AuthViewModel
import com.example.myuniclubs.data.ClubEntity

// Temporary sample clubs
val sampleClubs = listOf(
    ClubEntity(1, "Music Club", "Arts", "Love music? Join us!"),
    ClubEntity(2, "Gaming Club", "Entertainment", "Gamers unite!"),
    ClubEntity(3, "Chess Club", "Strategy", "Challenge your mind.")
)

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // ---------------- LOGIN ----------------
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    authViewModel.loadUserName() // load name after login
                    navController.navigate("home")
                },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }

        // ---------------- REGISTER ----------------
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = {
                    authViewModel.loadUserName() // load name after register
                    navController.navigate("home")
                },
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

        // ---------------- CLUB DETAILS ----------------
        composable("musicDetail") {
            MusicClubDetailScreen(onBack = { navController.popBackStack() })
        }

        composable("gamingDetail") {
            SportsClubDetailsScreen(onBack = { navController.popBackStack() })
        }

        composable("chessDetail") {
            ChessClubDetailScreen(onBack = { navController.popBackStack() })
        }

        // ---------------- SAVED ----------------
        composable("saved") {
            SavedClubsScreen(savedClubs = sampleClubs.filter { it.saved })
        }

        // ---------------- PROFILE ----------------
        composable("profile") {

            val name = authViewModel.currentUserName.value ?: "Student"
            val email = authViewModel.currentUserEmail ?: "Unknown Email"

            ProfileScreen(
                userName = name,
                userEmail = email,
                onNavigateToSaved = { navController.navigate("saved") },
                onLogout = {
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                onNavigateHome = { navController.navigate("home") }
            )
        }
    }
}
