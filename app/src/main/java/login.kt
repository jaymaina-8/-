package com.example.arsenal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arsenal.R
import com.example.arsenal.ui.theme.ARSENALTheme

@Composable
fun Login(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val primaryBlue = Color(0xFF2196F3)
    val secondaryBlue = Color(0xFF64B5F6)
    val containerBackground = Color(0xFFE3F2FD)
    val textFieldBackground = Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = containerBackground)
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.jay),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)

        )

        Text(
            text = "Login",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = primaryBlue
            )
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = if (!isValidEmail(email)) "Invalid email format" else ""
            },
            label = { Text("Email", color = secondaryBlue) },
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBackground, RoundedCornerShape(8.dp)),
        )

        if (errorMessage.isNotBlank()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = secondaryBlue) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBackground, RoundedCornerShape(8.dp)),
        )

        if (isLoading) {
            CircularProgressIndicator(color = primaryBlue)
        } else {
            Button(
                onClick = {navController.navigate("dashboard")
                    if (email.isNotBlank() && password.isNotBlank() && isValidEmail(email)) {
                        isLoading = true
                        // Simulate backend login process
                        // Add your actual logic here
                        isLoading = false
                    } else {
                        errorMessage = "Please enter valid credentials"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryBlue,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Login", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }
        }

        TextButton(onClick = { /* Navigate to registration page */ }) {
            Text(
                text = "Don't have an account? Register here",
                color = secondaryBlue,
                fontSize = 14.sp
            )
        }
    }
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    ARSENALTheme {
        //Login()
    }
}
