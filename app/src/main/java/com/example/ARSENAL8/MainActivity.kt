package com.example.ARSENAL8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ARSENAL8.ui.theme.ARSENALTheme
import navigation.AppNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Greeting()
            //Login()
         // Register()
           // Dashboard()
            //AddStudent()
            AppNavigation()
        }
        }
    }


@Composable
fun Greeting() {
    Text(
        text = "Hello ",

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ARSENALTheme {
      // Greeting()
       // Login()
       // Register()
       // Dashboard()
        //AddStudent()
    }
}