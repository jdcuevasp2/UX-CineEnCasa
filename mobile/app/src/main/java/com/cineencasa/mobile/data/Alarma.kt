package com.cineencasa.mobile.data

import androidx.annotation.DrawableRes

/** Entry shown in M-09 Mis alarmas — independent of the Movie catalog. */
data class Alarma(
    val id: Int,
    val movieTitle: String,
    val nextAlarmLabel: String,
    @DrawableRes val posterRes: Int,
    /** Links to a Movie.id for screens (M-05) that need full movie metadata; null while that movie isn't in MockMovies. */
    val movieId: Int? = null,
    val proximaAlarmaDetalle: String = "",
    val estrenoDetalle: String = "",
    /** Body text for M-12 ¿Aún te interesa...? confirmation. */
    val cancelConfirmBody: String = "",
    val streamingService: String = ""
)
