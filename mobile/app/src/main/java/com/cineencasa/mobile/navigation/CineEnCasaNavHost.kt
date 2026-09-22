package com.cineencasa.mobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cineencasa.mobile.data.MockMovies
import com.cineencasa.mobile.ui.screens.cartelera.CarteleraScreen
import com.cineencasa.mobile.ui.screens.detalle.DetalleScreen
import com.cineencasa.mobile.ui.screens.login.LoginScreen

@Composable
fun CineEnCasaNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginScreen(
                onIngresarClick = {
                    navController.navigate(Routes.Cartelera.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.Cartelera.route) {
            CarteleraScreen(
                movies = MockMovies.list,
                onMovieClick = { movie ->
                    navController.navigate(Routes.Detalle.createRoute(movie.id))
                }
            )
        }
        composable(
            route = Routes.Detalle.route,
            arguments = listOf(navArgument(Routes.Detalle.ARG_MOVIE_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt(Routes.Detalle.ARG_MOVIE_ID)
            val movie = MockMovies.findById(movieId ?: -1)
            if (movie != null) {
                DetalleScreen(
                    movie = movie,
                    onBackClick = { navController.popBackStack() },
                    onCrearAlarmaClick = { /* TODO(PR3): navegar a Confirmación cuando exista la ruta */ }
                )
            }
        }
    }
}
