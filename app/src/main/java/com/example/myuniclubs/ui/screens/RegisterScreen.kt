package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myuniclubs.ui.theme.BlueHeader
import com.example.myuniclubs.ui.theme.OrangeBackground
import com.example.myuniclubs.ui.theme.LightGrayField
import com.example.myuniclubs.ui.theme.BlueButton
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

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Auto-navigate when register is successful
    LaunchedEffect(authState) {
        if (authState is AuthState.Success) {
            onRegisterSuccess()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            // ------------ HEADER (Blue Bar) ------------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(BlueHeader),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "My Uni Clubs",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
            }

            // ------------ MAIN CONTENT (Orange Body) ------------
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
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(Modifier.height(20.dp))

                // Email Field (FIGMA: gray input box)
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = LightGrayField,
                        focusedContainerColor = LightGrayField
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                // Password Field
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = LightGrayField,
                        focusedContainerColor = LightGrayField
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(20.dp))

                // Error / Loading
                when (authState) {
                    is AuthState.Error ->
                        Text(
                            text = (authState as AuthState.Error).message,
                            color = MaterialTheme.colorScheme.error
                        )

                    AuthState.Loading -> CircularProgressIndicator()

                    else -> {}
                }

                Spacer(Modifier.height(20.dp))

                // Create Account Button (FIGMA Blue)
                Button(
                    onClick = {
                        if (email.isBlank() || password.isBlank()) {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("All fields are required")
                            }
                        } else {
                            viewModel.register(email, password)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton)
                ) {
                    Text("Create Account", color = Color.White)
                }

                Spacer(Modifier.height(12.dp))

                TextButton(
                    onClick = onNavigateToLogin
                ) {
                    Text("Already have an account? Login", color = Color.Black)
                }
            }
        }
    }
}



