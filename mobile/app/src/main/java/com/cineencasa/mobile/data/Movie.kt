package com.cineencasa.mobile.data

import androidx.annotation.DrawableRes

/**
 * Mock movie model shared by Cartelera, Detalle and Confirmación.
 * The Detalle-only fields default to empty/null since only Cartelera (M-03)
 * consumes this model in PR1 — Detalle (M-04, PR2) fills them in.
 */
data class Movie(
    val id: Int,
    val title: String,
    val genre: String,
    val year: Int,
    @DrawableRes val posterRes: Int,
    val durationLabel: String = "",
    val releaseDateLabel: String = "",
    val description: String = "",
    @DrawableRes val heroRes: Int? = null
)
