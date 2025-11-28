package com.example.myuniclubs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myuniclubs.viewmodel.AuthState
import com.example.myuniclubs.viewmodel.AuthViewModel
import com.example.myuniclubs.ui.theme.*

import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    viewModel: AuthViewModel = viewModel(),
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    val authState by viewModel.authState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Auto navigate after success
    LaunchedEffect(authState) {
        if (authState is AuthState.Success) onLoginSuccess()
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(OrangeBackground)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // ------------------ HEADER (BLUE) ------------------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(BlueHeader),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "My Uni Clubs",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkText
                )
            }

            Spacer(Modifier.height(30.dp))

            // ------------------ LOGIN BUTTONS (FIGMA STYLE TABS) ------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Login")
                }

                Spacer(Modifier.width(12.dp))

                Button(
                    onClick = onNavigateToRegister,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB4E64C)), // Green register tab
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Register")
                }
            }

            Spacer(Modifier.height(25.dp))

            // ------------------ EMAIL FIELD ------------------
            Text(
                text = "Email",
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = LightGrayField,
                    focusedContainerColor = LightGrayField
                )
            )

            Spacer(Modifier.height(15.dp))

            // ------------------ PASSWORD FIELD ------------------
            Text(
                text = "Password",
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = LightGrayField,
                    focusedContainerColor = LightGrayField
                )
            )

            Spacer(Modifier.height(28.dp))

            // LOGIN BUTTON (FIGMA BLUE)
            Button(
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Please enter email & password")
                        }
                    } else {
                        viewModel.login(email, password)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text("Login")
            }

            Spacer(Modifier.height(15.dp))

            // Navigate to Register
            TextButton(onClick = onNavigateToRegister) {
                Text("Don't have an account? Register")
            }
        }
    }
}
