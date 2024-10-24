package com.example.discovermovies.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.discovermovies.R
import com.example.discovermovies.ui.components.MainTopBar
import com.example.discovermovies.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(navController: NavController, moviesViewModel: MoviesViewModel = viewModel()) {
    Scaffold(
        topBar = { MainTopBar(stringResource(R.string.discover_movies), navController) },
        content = { padding ->
            Column( modifier = Modifier.padding(padding) ) {
                LazyColumn(
                    modifier = Modifier.padding(8.dp),
                ) {
                    items(moviesViewModel.moviesList) { movie->
                        Text(
                            text = movie.title,
                            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        Text(
                            text = movie.releaseDate,
                            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                            color = MaterialTheme.colorScheme.tertiary,
                        )
                        Text(
                            text = movie.voteAverage.toString(),
                            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
                    }
                }
            }
        }
    )
}