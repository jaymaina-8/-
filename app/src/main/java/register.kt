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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
import com.example.arsenal.R
import com.example.arsenal.ui.theme.ARSENALTheme

@Composable
fun Register() {
    var username by remember { mutableStateOf("") }
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
            text = "Register",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = primaryBlue
            )
        )

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                errorMessage = if (username.length < 5) "Username must be at least 5 characters long" else ""
            },
            label = { Text("Username", color = secondaryBlue) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Username Icon",
                    tint = secondaryBlue
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(textFieldBackground, RoundedCornerShape(8.dp)),
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = if (password.length < 8) "Password must be at least 8 characters long" else ""
            },
            label = { Text("Password", color = secondaryBlue) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password Icon",
                    tint = secondaryBlue
                )
            },
            visualTransformation = PasswordVisualTransformation(),
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

        if (isLoading) {
            CircularProgressIndicator(color = primaryBlue)
        } else {
            Button(
                onClick = {
                    if (username.isNotBlank() && password.isNotBlank() && username.length >= 5 && password.length >= 8) {
                        isLoading = true
                        // Simulate backend interaction (replace with actual logic)
                        isLoading = false
                    } else {
                        errorMessage = "Please fill all fields correctly"
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
                Text(text = "Register", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }
        }

        TextButton(onClick = { /* Navigate to Login Page */ }) {
            Text(
                text = "Already have an account? Login here",
                color = secondaryBlue,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    ARSENALTheme {
        Register()
    }
}
