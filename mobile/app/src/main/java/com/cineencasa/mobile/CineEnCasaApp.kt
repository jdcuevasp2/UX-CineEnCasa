package com.cineencasa.mobile

import androidx.compose.runtime.Composable
import com.cineencasa.mobile.navigation.CineEnCasaNavHost
import com.cineencasa.mobile.ui.theme.CineEnCasaTheme

@Composable
fun CineEnCasaApp() {
    CineEnCasaTheme {
        CineEnCasaNavHost()
    }
}
