package com.example.discovermovies.viewmodel

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.discovermovies.model.TmdbMovie
import com.example.discovermovies.model.TmdbMovieApi

class MoviesViewModel: ViewModel() {
    var moviesList = mutableListOf<TmdbMovie>()
        private set

    init {
        getMovies()
    }

    fun getMovies() {
        AsyncTask.execute {
            var tmdbMovieApi: TmdbMovieApi? = null

            try {
                tmdbMovieApi = TmdbMovieApi.getInstance()
                val movies = tmdbMovieApi!!.getPopular().execute()
                //Log.d("MOVIES", movies.body()?.results?.size.toString())
                moviesList.clear()
                moviesList.addAll(movies.body()!!.results!!)
                //Log.d("MOVIES", moviesList.toString())
            } catch (e: Exception) {
                Log.d("ERROR", e.toString())
            }
        }
    }
}