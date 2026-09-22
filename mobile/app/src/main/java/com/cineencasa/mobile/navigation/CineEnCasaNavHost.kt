package com.cineencasa.mobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cineencasa.mobile.data.MockMovies
import com.cineencasa.mobile.ui.screens.cartelera.CarteleraScreen
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
                onMovieClick = { /* TODO(PR2): navegar a Detalle cuando exista la ruta */ }
            )
        }
    }
}
