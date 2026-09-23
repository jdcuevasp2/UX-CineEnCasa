package com.cineencasa.mobile.ui.screens.cartelera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.cineencasa.mobile.ui.components.CineEnCasaTextField
import com.cineencasa.mobile.ui.components.CineEnCasaTopBar
import com.cineencasa.mobile.ui.components.MovieCard
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme
import kotlinx.coroutines.delay

/** Figma node 36:23517 — M-03 Cartelera (Home). */
@Composable
fun CarteleraScreen(
    movies: List<Movie>,
    onMovieClick: (Movie) -> Unit,
    onMisAlarmasClick: () -> Unit,
    modifier: Modifier = Modifier,
    pendingNotificationAlarmaId: Int? = null,
    onNotificationReady: (Int) -> Unit = {}
) {
    var query by remember { mutableStateOf("") }

    LaunchedEffect(pendingNotificationAlarmaId) {
        if (pendingNotificationAlarmaId != null) {
            delay(3000)
            onNotificationReady(pendingNotificationAlarmaId)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CineEnCasaTopBar(
                title = stringResource(id = R.string.cartelera_title),
                trailingIcon = {
                    IconButton(onClick = onMisAlarmasClick) {
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

            CineEnCasaTextField(
                value = query,
                onValueChange = { query = it },
                label = stringResource(id = R.string.cartelera_search_label),
                placeholder = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(movies.chunked(2)) { rowMovies ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Max),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        rowMovies.forEach { movie ->
                            MovieCard(
                                movie = movie,
                                onClick = { onMovieClick(movie) },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            )
                        }
                        if (rowMovies.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131C, widthDp = 393, heightDp = 852)
@Composable
private fun CarteleraScreenPreview() {
    CineEnCasaTheme {
        CarteleraScreen(movies = MockMovies.list, onMovieClick = {}, onMisAlarmasClick = {})
    }
}
