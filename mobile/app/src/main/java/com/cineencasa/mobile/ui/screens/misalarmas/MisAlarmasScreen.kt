package com.cineencasa.mobile.ui.screens.misalarmas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cineencasa.mobile.R
import com.cineencasa.mobile.data.Alarma
import com.cineencasa.mobile.data.MockAlarmas
import com.cineencasa.mobile.ui.components.CineEnCasaTopBar
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme
import com.cineencasa.mobile.ui.theme.Outline

/** Figma node 50:25347 — M-09 Mis alarmas. */
@Composable
fun MisAlarmasScreen(
    alarmas: List<Alarma>,
    onBackClick: () -> Unit,
    onAlarmaClick: (Alarma) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            Column {
                CineEnCasaTopBar(
                    title = stringResource(id = R.string.mis_alarmas_title),
                    onBackClick = onBackClick
                )
                HorizontalDivider(color = Outline)
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(alarmas) { alarma ->
                AlarmaRow(alarma = alarma, onClick = { onAlarmaClick(alarma) })
                HorizontalDivider(color = Outline)
            }
        }
    }
}

@Composable
private fun AlarmaRow(alarma: Alarma, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = alarma.posterRes),
            contentDescription = alarma.movieTitle,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(48.dp)
                .height(64.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = alarma.movieTitle,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = alarma.nextAlarmLabel,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131C, widthDp = 393, heightDp = 852)
@Composable
private fun MisAlarmasScreenPreview() {
    CineEnCasaTheme {
        MisAlarmasScreen(alarmas = MockAlarmas.list, onBackClick = {}, onAlarmaClick = {})
    }
}
