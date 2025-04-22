package navigation

import HomeScreen
import Register
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ARSENAL8.Dashboard
import com.example.ARSENAL8.AddStudent
import com.example.ARSENAL8.Login
import com.example.ARSENAL8.splashscreen
import com.example.ARSENAL8.viewModel.AuthviewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authviewModel= AuthviewModel()
    NavHost(
        navController = navController,
        startDestination = "splashscreen"){

        composable("login") { Login(navController) }
        composable("register") { Register(navController, authviewModel) }
        composable("dashboard") { Dashboard(navController) }
        composable("Addstudent") { AddStudent(navController) }
        composable("HomeScreen") { HomeScreen (navController) }
        composable("splashscreen") { splashscreen(navController) }
    }
}