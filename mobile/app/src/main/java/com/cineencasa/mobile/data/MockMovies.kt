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
            releaseDateLabel = "En cines desde el 31 de julio",
            description = "Peter Parker vive totalmente solo y olvidado por todos tras los eventos de No Way Home, dedicándose a proteger Nueva York como un héroe callejero a tiempo completo.",
            heroRes = R.drawable.poster_spiderman
        ),
        Movie(
            id = 2,
            title = "Coyote vs. Acme",
            genre = "Aventura",
            year = 2026,
            posterRes = R.drawable.poster_coyote,
            durationLabel = "1 h 31 m",
            releaseDateLabel = "En cines desde el 27 de agosto",
            description = "Wile E. Coyote demanda a Acme Corporation por los innumerables productos defectuosos que ha usado durante años para intentar atrapar al Correcaminos, en un enfrentamiento legal tan absurdo como divertido.",
            heroRes = R.drawable.poster_coyote
        ),
        Movie(
            id = 3,
            title = "La Odisea",
            genre = "Aventura",
            year = 2026,
            posterRes = R.drawable.poster_odisea,
            durationLabel = "2 h 30 m",
            releaseDateLabel = "En cines desde el 16 de julio",
            description = "Basada en el poema épico de Homero, sigue el arriesgado viaje de regreso a casa de Odiseo tras la guerra de Troya, enfrentando peligros míticos que ponen a prueba su ingenio y su voluntad.",
            heroRes = R.drawable.poster_odisea
        ),
        Movie(
            id = 4,
            title = "Masha y los osos",
            genre = "Comedia",
            year = 2026,
            posterRes = R.drawable.poster_masha,
            durationLabel = "1 h 28 m",
            releaseDateLabel = "En cines desde el 12 de septiembre",
            description = "Los queridos personajes animados de Masha y el Oso cobran vida en una nueva aventura familiar llena de humor y grandes enseñanzas sobre la amistad.",
            heroRes = R.drawable.poster_masha
        )
    )

    fun findById(id: Int): Movie? = list.find { it.id == id }
}
