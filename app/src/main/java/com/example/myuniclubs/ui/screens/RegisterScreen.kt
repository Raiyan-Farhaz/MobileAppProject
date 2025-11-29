package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myuniclubs.ui.theme.BlueHeader
import com.example.myuniclubs.ui.theme.OrangeBackground
import com.example.myuniclubs.ui.theme.BlueButton
import com.example.myuniclubs.ui.theme.LightGrayField
import com.example.myuniclubs.ui.theme.DarkText
import com.example.myuniclubs.viewmodel.AuthState
import com.example.myuniclubs.viewmodel.AuthViewModel
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    viewModel: AuthViewModel = viewModel(),
    onRegisterSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val authState by viewModel.authState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Navigate when registration succeeds
    LaunchedEffect(authState) {
        if (authState is AuthState.Success) {
            onRegisterSuccess()
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { padding ->

        Column(modifier = Modifier.fillMaxSize()) {

            // ---------------- HEADER ----------------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(BlueHeader),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "My Uni Clubs",
                    fontWeight = FontWeight.Bold,
                    color = DarkText,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            // ---------------- ORANGE BACKGROUND ----------------
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(OrangeBackground)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(Modifier.height(10.dp))

                Text(
                    text = "Register",
                    fontWeight = FontWeight.Bold,
                    color = DarkText,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(Modifier.height(20.dp))

                // ---------- NAME ----------
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Full Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGrayField, RoundedCornerShape(10.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = LightGrayField,
                        unfocusedContainerColor = LightGrayField
                    )
                )

                Spacer(Modifier.height(10.dp))

                // ---------- EMAIL ----------
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGrayField, RoundedCornerShape(10.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = LightGrayField,
                        unfocusedContainerColor = LightGrayField
                    )
                )

                Spacer(Modifier.height(10.dp))

                // ---------- PASSWORD ----------
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGrayField, RoundedCornerShape(10.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = LightGrayField,
                        unfocusedContainerColor = LightGrayField
                    )
                )

                Spacer(Modifier.height(20.dp))

                // ---------- ERROR + LOADING ----------
                when (authState) {
                    is AuthState.Error -> Text(
                        (authState as AuthState.Error).message,
                        color = Color.Red
                    )
                    AuthState.Loading -> CircularProgressIndicator()
                    else -> {}
                }

                Spacer(Modifier.height(20.dp))

                // ---------- REGISTER BUTTON ----------
                Button(
                    onClick = {
                        if (name.isBlank() || email.isBlank() || password.isBlank()) {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("All fields are required")
                            }
                        } else {
                            viewModel.registerWithName(name, email, password)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Create Account", color = Color.White)
                }

                Spacer(Modifier.height(10.dp))

                TextButton(onClick = onNavigateToLogin) {
                    Text("Already have an account? Login", color = DarkText)
                }
            }
        }
    }
}
