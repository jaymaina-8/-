package navigation

import Register
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arsenal.Dashboard
import androidx.navigation.NavController
import com.example.arsenal.AddStudent
import com.example.arsenal.Login


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Login"){

        composable("login") { Login(navController) }
        composable("register") { Register(navController) }
        composable("dashboard") { Dashboard(navController) }
        composable("Addstudent") { AddStudent(navController) }
    }
}