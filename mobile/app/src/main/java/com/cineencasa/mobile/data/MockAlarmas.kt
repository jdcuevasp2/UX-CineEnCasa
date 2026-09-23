package com.cineencasa.mobile.data

import com.cineencasa.mobile.R

object MockAlarmas {
    val list = listOf(
        Alarma(
            id = 1,
            movieTitle = "Spider-Man: Brand New Day",
            nextAlarmLabel = "Próxima alarma: en 6 días (1 semana antes)",
            posterRes = R.drawable.poster_spiderman,
            movieId = 1,
            proximaAlarmaDetalle = "Próxima alarma: en 6 días — 1 semana antes (sáb 12 sep)",
            estrenoDetalle = "Estreno: sáb 19 sep · Netflix",
            cancelConfirmBody = "Llega a streaming mañana (sáb 19 sep, en Netflix).",
            streamingService = "Netflix"
        ),
        Alarma(
            id = 2,
            movieTitle = "Toy Story 5",
            nextAlarmLabel = "Próxima alarma: en 3 semanas (1 semana antes)",
            posterRes = R.drawable.poster_toystory
        ),
        Alarma(
            id = 3,
            movieTitle = "Avatar: Fuego y cenizas",
            nextAlarmLabel = "Próxima alarma: en 5 semanas (1 semana antes)",
            posterRes = R.drawable.poster_avatar
        )
    )
}
