package com.cineencasa.mobile.ui.screens.cartelera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cineencasa.mobile.R
import com.cineencasa.mobile.data.Movie
import com.cineencasa.mobile.data.MockMovies
import com.cineencasa.mobile.ui.components.CineEnCasaTopBar
import com.cineencasa.mobile.ui.components.MovieCard
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme
import com.cineencasa.mobile.ui.theme.Outline
import com.cineencasa.mobile.ui.theme.PlaceholderTertiary
import com.cineencasa.mobile.ui.theme.Surface as SurfaceColor

/** Figma node 36:23517 — M-03 Cartelera (Home). */
@Composable
fun CarteleraScreen(
    movies: List<Movie>,
    onMovieClick: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CineEnCasaTopBar(
                title = stringResource(id = R.string.cartelera_title),
                trailingIcon = {
                    IconButton(onClick = { /* Perfil: fuera de alcance en esta fase */ }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = stringResource(id = R.string.content_description_account),
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.cartelera_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text(stringResource(id = R.string.cartelera_search_label)) },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = SurfaceColor,
                    unfocusedContainerColor = SurfaceColor,
                    focusedBorderColor = Outline,
                    unfocusedBorderColor = Outline,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = PlaceholderTertiary,
                    unfocusedLabelColor = PlaceholderTertiary,
                    cursorColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(movies) { movie ->
                    MovieCard(movie = movie, onClick = { onMovieClick(movie) })
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131C, widthDp = 393, heightDp = 852)
@Composable
private fun CarteleraScreenPreview() {
    CineEnCasaTheme {
        CarteleraScreen(movies = MockMovies.list, onMovieClick = {})
    }
}
