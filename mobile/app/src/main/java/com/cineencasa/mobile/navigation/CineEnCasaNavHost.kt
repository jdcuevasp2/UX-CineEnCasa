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
import com.cineencasa.mobile.ui.screens.confirmacion.ConfirmacionScreen
import com.cineencasa.mobile.ui.screens.detalle.DetalleScreen
import com.cineencasa.mobile.ui.screens.login.LoginScreen
import com.cineencasa.mobile.data.MockAlarmas
import com.cineencasa.mobile.ui.screens.detalle.DetalleConAlarmaScreen
import com.cineencasa.mobile.ui.screens.misalarmas.MisAlarmasScreen

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
                },
                onMisAlarmasClick = {
                    navController.navigate(Routes.MisAlarmas.route)
                }
            )
        }
        composable(Routes.MisAlarmas.route) {
            MisAlarmasScreen(
                alarmas = MockAlarmas.list,
                onBackClick = { navController.popBackStack() },
                onAlarmaClick = { alarma ->
                    // Por ahora solo Spider-Man tiene datos completos de M-05
                    if (alarma.movieId != null) {
                        navController.navigate(Routes.DetalleConAlarma.createRoute(alarma.id))
                    }
                }
            )
        }
        composable(
            route = Routes.DetalleConAlarma.route,
            arguments = listOf(navArgument(Routes.DetalleConAlarma.ARG_ALARMA_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val alarmaId = backStackEntry.arguments?.getInt(Routes.DetalleConAlarma.ARG_ALARMA_ID)
            val alarma = MockAlarmas.list.find { it.id == alarmaId }
            val movie = alarma?.movieId?.let { MockMovies.findById(it) }
            if (alarma != null && movie != null) {
                DetalleConAlarmaScreen(
                    movie = movie,
                    alarma = alarma,
                    onBackClick = { navController.popBackStack() },
                    onCancelarAlarmaClick = { /* Cancelar alarma: fuera de alcance en esta fase */ }
                )
            }
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
                    onCrearAlarmaClick = {
                        navController.navigate(Routes.Confirmacion.createRoute(movie.id))
                    }
                )
            }
        }
        composable(
            route = Routes.Confirmacion.route,
            arguments = listOf(navArgument(Routes.Confirmacion.ARG_MOVIE_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt(Routes.Confirmacion.ARG_MOVIE_ID)
            val movie = MockMovies.findById(movieId ?: -1)
            if (movie != null) {
                ConfirmacionScreen(
                    movieTitle = movie.title,
                    onVolverClick = {
                        navController.navigate(Routes.Cartelera.route) {
                            popUpTo(Routes.Cartelera.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}
