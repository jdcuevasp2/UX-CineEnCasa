package com.cineencasa.mobile.data

import com.cineencasa.mobile.R

object MockMovies {
    val list = listOf(
        Movie(
            id = 1,
            title = "Spider-Man: Brand New Day",
            genre = "Acción",
            year = 2026,
            posterRes = R.drawable.poster_spiderman,
            durationLabel = "2 h 30 m",
            releaseDateLabel = "En cines desde el 31 de Julio",
            description = "Peter Parker vive totalmente solo y olvidado por todos tras los eventos de No Way Home, dedicándose a proteger Nueva York como un héroe callejero a tiempo completo.",
            heroRes = R.drawable.poster_spiderman
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
