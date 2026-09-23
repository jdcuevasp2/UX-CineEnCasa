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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cineencasa.mobile.R
import com.cineencasa.mobile.ui.components.FeedbackDialogCard
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme

/** Figma node 52:836 — M-12 Notificación (1 día antes / confirmar cancelación). */
@Composable
fun CancelarAlarmaScreen(
    movieTitle: String,
    releaseInfo: String,
    onSiClick: () -> Unit,
    onNoClick: () -> Unit,
    modifier: Modifier = Modifier
) {
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
                title = stringResource(id = R.string.notificacion_cancelar_title, movieTitle),
                body = releaseInfo
            ) {
                TextButton(onClick = onSiClick) {
                    Text(text = stringResource(id = R.string.accion_si))
                }
                TextButton(onClick = onNoClick) {
                    Text(text = stringResource(id = R.string.accion_no))
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131C, widthDp = 393, heightDp = 852)
@Composable
private fun CancelarAlarmaScreenPreview() {
    CineEnCasaTheme {
        CancelarAlarmaScreen(
            movieTitle = "Spider-Man: Brand New Day",
            releaseInfo = "Llega a streaming mañana (sáb 19 sep, en Netflix).",
            onSiClick = {},
            onNoClick = {}
        )
    }
}
