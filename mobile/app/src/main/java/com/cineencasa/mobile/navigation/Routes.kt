package com.cineencasa.mobile.navigation

/** Nav route definitions. */
sealed class Routes(val route: String) {
    data object Login : Routes("login")
    data object Cartelera : Routes("cartelera")
    data object MisAlarmas : Routes("mis-alarmas")
    data object Detalle : Routes("detalle/{movieId}") {
        const val ARG_MOVIE_ID = "movieId"
        fun createRoute(movieId: Int) = "detalle/$movieId"
    }
    data object DetalleConAlarma : Routes("detalle-alarma/{alarmaId}") {
        const val ARG_ALARMA_ID = "alarmaId"
        fun createRoute(alarmaId: Int) = "detalle-alarma/$alarmaId"
    }
    data object Confirmacion : Routes("confirmacion/{movieId}") {
        const val ARG_MOVIE_ID = "movieId"
        fun createRoute(movieId: Int) = "confirmacion/$movieId"
    }
}
