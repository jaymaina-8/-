import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arsenal.BottomNav
import com.example.arsenal.TopBar
import com.example.arsenal.ui.theme.ARSENALTheme
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) { // Added NavController as a parameter
    Scaffold(
        topBar = { TopBar("HOME SCREEN") },
        bottomBar = { BottomNav(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "WELCOME TO MY HOME SCREEN",
                modifier = Modifier.padding(16.dp)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ARSENALTheme {
        val navController = rememberNavController() // Added navController for the preview
        HomeScreen(navController = navController)
    }
}
