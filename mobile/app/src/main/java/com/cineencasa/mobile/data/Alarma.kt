package com.cineencasa.mobile.data

import androidx.annotation.DrawableRes

/** Entry shown in M-09 Mis alarmas — independent of the Movie catalog. */
data class Alarma(
    val id: Int,
    val movieTitle: String,
    val nextAlarmLabel: String,
    @DrawableRes val posterRes: Int
)
