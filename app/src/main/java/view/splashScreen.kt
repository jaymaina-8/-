package com.example.ARSENAL8

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay


@Composable
fun splashscreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.index),
                contentDescription = "logo",
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 0.dp, bottom = 2.dp)
                    .clip(RoundedCornerShape(4000.dp)),
                contentScale = ContentScale.Crop
            )
            Column() {
                Spacer(modifier = Modifier.height(300.dp))

                Text(
                    "Welcome to my app",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Cursive,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(horizontal = 75.dp)
                )

            }
        }
    }

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("login") {
            popUpTo("splashscreen") { inclusive = true }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun splashscreenpreview() {
    val mockNavController = rememberNavController()
    splashscreen(navController = mockNavController)
}