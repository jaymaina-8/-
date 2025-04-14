import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.navigation.compose.rememberNavController
import com.example.arsenal.R
import com.example.arsenal.ui.theme.ARSENALTheme

@Composable
fun Register(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    val primaryColor = Color.Black
    val secondaryColor = Color.Black
    val backgroundColor = Color.White
    val textFieldBackground = Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.jay),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Register",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
        )

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                errorMessage =
                    if (username.length < 5) "Username must be at least 5 characters long" else ""
            },
            label = { Text("Username", color = secondaryColor) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Username Icon",
                    tint = secondaryColor
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBackground, RoundedCornerShape(8.dp))
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage =
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                        "Invalid email address" else ""
            },
            label = { Text("Email", color = secondaryColor) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon",
                    tint = secondaryColor
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBackground, RoundedCornerShape(8.dp))
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage =
                    if (password.length < 8) "Password must be at least 8 characters long" else ""
            },
            label = { Text("Password", color = secondaryColor) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password Icon",
                    tint = secondaryColor
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBackground, RoundedCornerShape(8.dp))
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                errorMessage =
                    if (confirmPassword != password) "Passwords do not match" else ""
            },
            label = { Text("Confirm Password", color = secondaryColor) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Confirm Password Icon",
                    tint = secondaryColor
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBackground, RoundedCornerShape(8.dp))
        )

        Text(
            text = errorMessage,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (username.isNotBlank() && email.isNotBlank() && password.isNotBlank() &&
                    confirmPassword.isNotBlank() && username.length >= 5 &&
                    android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                    password.length >= 8 && confirmPassword == password
                ) {
                    errorMessage = ""
                    // Backend logic simulation
                } else {
                    errorMessage = "Please fill all fields correctly"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Register",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        TextButton(onClick = { navController.navigate("login") }) {
            Text(
                text = "Already have an account? Login here",
                color = secondaryColor,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    ARSENALTheme {
        val mockNavController = rememberNavController()
        Register(navController = mockNavController)
    }
}