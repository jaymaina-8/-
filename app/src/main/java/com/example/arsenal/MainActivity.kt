package com.example.arsenal

import Register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.arsenal.ui.theme.ARSENALTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Greeting()
            //Login()
         // Register()
            //dashboard()
            AddStudent()
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
       // dashboard()
        AddStudent()
    }
}