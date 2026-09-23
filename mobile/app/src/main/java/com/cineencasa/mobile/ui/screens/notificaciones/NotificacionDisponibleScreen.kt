package com.cineencasa.mobile.ui.screens.notificaciones

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.content.Intent
import android.net.Uri
import com.cineencasa.mobile.R
import com.cineencasa.mobile.ui.components.FeedbackDialogCard
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme

private const val DISNEY_PLUS_URL = "https://www.disneyplus.com/"

/** Figma node 52:861 — M-13 Notificación (1 hora antes / final, ya disponible). */
@Composable
fun NotificacionDisponibleScreen(
    movieTitle: String,
    streamingService: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            FeedbackDialogCard(
                title = stringResource(id = R.string.notificacion_disponible_title),
                body = stringResource(id = R.string.notificacion_disponible_body, movieTitle, streamingService)
            ) {
                TextButton(onClick = {
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(DISNEY_PLUS_URL)))
                }) {
                    Text(text = stringResource(id = R.string.accion_ver_ahora))
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131C, widthDp = 393, heightDp = 852)
@Composable
private fun NotificacionDisponibleScreenPreview() {
    CineEnCasaTheme {
        NotificacionDisponibleScreen(
            movieTitle = "Spider-Man: Brand New Day",
            streamingService = "Netflix"
        )
    }
}
