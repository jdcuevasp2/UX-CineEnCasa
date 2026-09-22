package com.cineencasa.mobile.ui.screens.confirmacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cineencasa.mobile.R
import com.cineencasa.mobile.data.MockMovies
import com.cineencasa.mobile.ui.components.PrimaryButton
import com.cineencasa.mobile.ui.theme.BannerVerdeSuccess
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme
import com.cineencasa.mobile.ui.theme.PlaceholderTertiary

/** Figma node 46:545 — M-06 Confirmación de alarma. */
@Composable
fun ConfirmacionScreen(
    movieTitle: String,
    onVolverClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Alarm,
                contentDescription = null,
                tint = BannerVerdeSuccess,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = stringResource(id = R.string.confirmacion_title),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = stringResource(id = R.string.confirmacion_body, movieTitle),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = stringResource(id = R.string.confirmacion_note),
                style = MaterialTheme.typography.bodyLarge,
                color = PlaceholderTertiary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            PrimaryButton(
                text = stringResource(id = R.string.confirmacion_volver),
                onClick = onVolverClick
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131C, widthDp = 393, heightDp = 852)
@Composable
private fun ConfirmacionScreenPreview() {
    CineEnCasaTheme {
        ConfirmacionScreen(
            movieTitle = MockMovies.findById(1)!!.title,
            onVolverClick = {}
        )
    }
}
