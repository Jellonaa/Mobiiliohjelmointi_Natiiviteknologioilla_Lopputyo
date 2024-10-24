package com.example.discovermovies.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.discovermovies.R
import com.example.discovermovies.ui.components.ScreenTopBar

@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar("Info", navController) },
        content = { padding ->
            Column( modifier = Modifier.padding(padding).width(320.dp) ) {
                Text(text = stringResource(R.string.shows_a_list_of_20_movies_from_the_tmdb_discover_feature))
            }
        }
    )
}