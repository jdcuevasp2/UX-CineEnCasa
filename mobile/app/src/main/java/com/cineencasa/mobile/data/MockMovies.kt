package com.cineencasa.mobile.data

import com.cineencasa.mobile.R

object MockMovies {
    val list = listOf(
        Movie(
            id = 1,
            title = "Spider-Man: Brand New Day",
            genre = "Acción",
            year = 2026,
            posterRes = R.drawable.poster_spiderman
        ),
        Movie(
            id = 2,
            title = "Coyote vs. Acme",
            genre = "Aventura",
            year = 2026,
            posterRes = R.drawable.poster_coyote
        ),
        Movie(
            id = 3,
            title = "La Odisea",
            genre = "Aventura",
            year = 2026,
            posterRes = R.drawable.poster_odisea
        ),
        Movie(
            id = 4,
            title = "Masha y los osos",
            genre = "Comedia",
            year = 2026,
            posterRes = R.drawable.poster_masha
        )
    )

    fun findById(id: Int): Movie? = list.find { it.id == id }
}
