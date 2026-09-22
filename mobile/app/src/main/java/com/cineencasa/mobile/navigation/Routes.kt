package com.cineencasa.mobile.navigation

/**
 * Nav route definitions. `Confirmacion` is added in PR3 once that screen
 * exists — no dead routes are registered ahead of time.
 */
sealed class Routes(val route: String) {
    data object Login : Routes("login")
    data object Cartelera : Routes("cartelera")
    data object Detalle : Routes("detalle/{movieId}") {
        const val ARG_MOVIE_ID = "movieId"
        fun createRoute(movieId: Int) = "detalle/$movieId"
    }
}
