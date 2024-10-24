package com.example.discovermovies.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.discovermovies.R
import com.example.discovermovies.ui.screens.InfoScreen
import com.example.discovermovies.ui.screens.MoviesScreen
import com.example.discovermovies.ui.theme.DiscoverMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiscoverMoviesTheme {
                Movies()
            }
        }
    }
}

@Composable
fun Movies() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = stringResource(R.string.home)
    ) {
        composable(route = "Home") {
            MoviesScreen(navController)
        }
        composable(route = "Info") {
            InfoScreen(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiscoverMoviesTheme {
        Movies()
    }
}