package com.cineencasa.mobile.navigation

/**
 * Nav route definitions. `Detalle`/`Confirmacion` are added in PR2/PR3 once
 * their screens exist — no dead routes are registered ahead of time.
 */
sealed class Routes(val route: String) {
    data object Login : Routes("login")
    data object Cartelera : Routes("cartelera")
}
