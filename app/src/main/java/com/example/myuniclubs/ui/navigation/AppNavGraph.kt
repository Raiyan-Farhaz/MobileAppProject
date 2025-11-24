package com.example.myuniclubs.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.myuniclubs.ui.screens.*
import com.example.myuniclubs.data.ClubEntity

// Temporary sample clubs (replace with Room later)
val sampleClubs = listOf(
    ClubEntity(id = 1, name = "Music Club", category = "Arts", description = "Love music? Join us!"),
    ClubEntity(id = 2, name = "Gaming Club", category = "Entertainment", description = "Gamers unite!"),
    ClubEntity(id = 3, name = "Chess Club", category = "Strategy", description = "Challenge your mind.")
)

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("home") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }

        composable("register") {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate("home") },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }

        composable("home") {
            HomeScreen(
                onNavigateToClubs = { navController.navigate("clubs") },
                onNavigateToSaved = { navController.navigate("saved") }
            )
        }

        // ---------------- NEW FOR SPRINT 3 ----------------

        // Clubs list
        composable("clubs") {
            ClubListScreen(
                clubs = sampleClubs,
                onClubClick = { club ->
                    navController.navigate("clubDetail/${club.id}")
                }
            )
        }

        // Club details
        composable(
            route = "clubDetail/{clubId}",
            arguments = listOf(navArgument("clubId") { type = NavType.IntType })
        ) { backStackEntry ->
            val clubId = backStackEntry.arguments?.getInt("clubId") ?: 0
            val club = sampleClubs.first { it.id == clubId }

            ClubDetailScreen(
                club = club,
                onBack = { navController.popBackStack() },
                onSaveToggle = { /* TODO: connect to Room */ }
            )
        }

        // Saved clubs
        composable("saved") {
            SavedClubsScreen(
                savedClubs = sampleClubs.filter { it.saved }
            )
        }
    }
}
