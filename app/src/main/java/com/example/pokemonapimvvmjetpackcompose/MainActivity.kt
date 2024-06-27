package com.example.pokemonapimvvmjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokemonapimvvmjetpackcompose.ui.nav.NavRoutes.Companion.DOMINANT_COLOR
import com.example.pokemonapimvvmjetpackcompose.ui.nav.NavRoutes.Companion.POKEMON_DETAIL_SCREEN
import com.example.pokemonapimvvmjetpackcompose.ui.nav.NavRoutes.Companion.POKEMON_LIST_SCREEN
import com.example.pokemonapimvvmjetpackcompose.ui.nav.NavRoutes.Companion.POKEMON_NAME
import com.example.pokemonapimvvmjetpackcompose.ui.theme.JetpackComposePokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposePokedexTheme {
                navigation()
            }
        }
    }
}

@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = POKEMON_LIST_SCREEN
    ) {
        composable(POKEMON_LIST_SCREEN) {
            //to do when adding the screen
        }
        composable(
            "pokemon_detail_screen/{dominantColor}/{pokemonName}",
            arguments = listOf(
                navArgument(DOMINANT_COLOR) {
                    type = NavType.IntType
                },
                navArgument(POKEMON_NAME) {
                    type = NavType.StringType
                }
            )
        ) {
            val dominantColor = remember {
                val color = it.arguments?.getInt(DOMINANT_COLOR)
                color?.let { Color(it) } ?: Color.White
            }
            val pokemonName = remember {
                it.arguments?.getString(POKEMON_NAME)

            }
            //here would be the composable for the pokemon detail screen
        }
    }


}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePokedexTheme {
        Greeting("Android")
    }
}