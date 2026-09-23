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
import com.cineencasa.mobile.ui.screens.notificaciones.CancelarAlarmaScreen
import com.cineencasa.mobile.ui.screens.notificaciones.NotificacionDisponibleScreen

@Composable
fun CineEnCasaNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginScreen(
                onIngresarClick = {
                    navController.navigate(Routes.Cartelera.createRoute()) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(
            route = Routes.Cartelera.route,
            arguments = listOf(
                navArgument(Routes.Cartelera.ARG_ALARMA_ID) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { backStackEntry ->
            val triggerAlarmaId = backStackEntry.arguments
                ?.getInt(Routes.Cartelera.ARG_ALARMA_ID)
                ?.takeIf { it != -1 }
            CarteleraScreen(
                movies = MockMovies.list,
                onMovieClick = { movie ->
                    navController.navigate(Routes.Detalle.createRoute(movie.id))
                },
                onMisAlarmasClick = {
                    navController.navigate(Routes.MisAlarmas.route)
                },
                pendingNotificationAlarmaId = triggerAlarmaId,
                onNotificationReady = { alarmaId ->
                    navController.navigate(Routes.NotificacionDisponible.createRoute(alarmaId))
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
                    onCancelarAlarmaClick = {
                        navController.navigate(Routes.CancelarAlarma.createRoute(alarma.id))
                    }
                )
            }
        }
        composable(
            route = Routes.CancelarAlarma.route,
            arguments = listOf(navArgument(Routes.CancelarAlarma.ARG_ALARMA_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val alarmaId = backStackEntry.arguments?.getInt(Routes.CancelarAlarma.ARG_ALARMA_ID)
            val alarma = MockAlarmas.list.find { it.id == alarmaId }
            if (alarma != null) {
                val goToCartelera: () -> Unit = {
                    navController.navigate(Routes.Cartelera.createRoute(alarma.id)) {
                        popUpTo(Routes.Cartelera.route) { inclusive = false }
                        launchSingleTop = true
                    }
                }
                CancelarAlarmaScreen(
                    movieTitle = alarma.movieTitle,
                    releaseInfo = alarma.cancelConfirmBody,
                    onSiClick = goToCartelera,
                    onNoClick = goToCartelera
                )
            }
        }
        composable(
            route = Routes.NotificacionDisponible.route,
            arguments = listOf(navArgument(Routes.NotificacionDisponible.ARG_ALARMA_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val alarmaId = backStackEntry.arguments?.getInt(Routes.NotificacionDisponible.ARG_ALARMA_ID)
            val alarma = MockAlarmas.list.find { it.id == alarmaId }
            if (alarma != null) {
                NotificacionDisponibleScreen(
                    movieTitle = alarma.movieTitle,
                    streamingService = alarma.streamingService
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
                        navController.navigate(Routes.Cartelera.createRoute()) {
                            popUpTo(Routes.Cartelera.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}
