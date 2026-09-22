package com.cineencasa.mobile.ui.screens.detalle

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cineencasa.mobile.R
import com.cineencasa.mobile.data.Movie
import com.cineencasa.mobile.data.MockMovies
import com.cineencasa.mobile.ui.components.CineEnCasaTopBar
import com.cineencasa.mobile.ui.components.PrimaryButton
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme
import com.cineencasa.mobile.ui.theme.Outline
import com.cineencasa.mobile.ui.theme.PlaceholderTertiary
import com.cineencasa.mobile.ui.theme.Surface as SurfaceColor

/** Figma node 36:23586 — M-04 Detalle (sin alarma). */
@Composable
fun DetalleScreen(
    movie: Movie,
    onBackClick: () -> Unit,
    onCrearAlarmaClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            Column {
                CineEnCasaTopBar(
                    title = stringResource(id = R.string.detalle_title),
                    onBackClick = onBackClick
                )
                HorizontalDivider(color = Outline)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = movie.heroRes ?: movie.posterRes),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(442.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(
                        id = R.string.detalle_meta_format,
                        movie.genre,
                        movie.year,
                        movie.durationLabel
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Surface(
                    color = SurfaceColor,
                    border = BorderStroke(1.dp, Outline),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(PlaceholderTertiary)
                        )
                        Text(
                            text = movie.releaseDateLabel,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }

                Text(
                    text = movie.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                PrimaryButton(
                    text = stringResource(id = R.string.detalle_create_alarm),
                    onClick = onCrearAlarmaClick,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = stringResource(id = R.string.detalle_alarm_note),
                    style = MaterialTheme.typography.labelSmall,
                    color = PlaceholderTertiary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131C, widthDp = 393, heightDp = 852)
@Composable
private fun DetalleScreenPreview() {
    CineEnCasaTheme {
        DetalleScreen(
            movie = MockMovies.findById(1)!!,
            onBackClick = {},
            onCrearAlarmaClick = {}
        )
    }
}
