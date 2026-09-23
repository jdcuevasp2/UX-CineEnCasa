package com.cineencasa.mobile.ui.screens.detalle

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cineencasa.mobile.R
import com.cineencasa.mobile.data.Alarma
import com.cineencasa.mobile.data.Movie
import com.cineencasa.mobile.data.MockAlarmas
import com.cineencasa.mobile.data.MockMovies
import com.cineencasa.mobile.ui.components.CineEnCasaTopBar
import com.cineencasa.mobile.ui.components.OutlinedActionButton
import com.cineencasa.mobile.ui.theme.BannerVerdeSuccess
import com.cineencasa.mobile.ui.theme.BannerVerdeSuccessBorder
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme
import com.cineencasa.mobile.ui.theme.Outline
import com.cineencasa.mobile.ui.theme.Surface as SurfaceColor

/** Figma node 46:490 — M-05 Detalle (con alarma). */
@Composable
fun DetalleConAlarmaScreen(
    movie: Movie,
    alarma: Alarma,
    onBackClick: () -> Unit,
    onCancelarAlarmaClick: () -> Unit,
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
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Surface(
                    color = BannerVerdeSuccess.copy(alpha = 0.15f),
                    border = BorderStroke(1.dp, BannerVerdeSuccessBorder),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.detalle_alarma_activa),
                        style = MaterialTheme.typography.labelLarge,
                        color = BannerVerdeSuccess,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }

                Surface(
                    color = SurfaceColor,
                    border = BorderStroke(1.dp, Outline),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = alarma.proximaAlarmaDetalle,
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = alarma.estrenoDetalle,
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                OutlinedActionButton(
                    text = stringResource(id = R.string.detalle_cancelar_alarma),
                    onClick = onCancelarAlarmaClick
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131C, widthDp = 393, heightDp = 852)
@Composable
private fun DetalleConAlarmaScreenPreview() {
    CineEnCasaTheme {
        DetalleConAlarmaScreen(
            movie = MockMovies.findById(1)!!,
            alarma = MockAlarmas.list.first(),
            onBackClick = {},
            onCancelarAlarmaClick = {}
        )
    }
}
