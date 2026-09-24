# CineEnCasa — Android

App Android (Kotlin + Jetpack Compose + Material 3) del proyecto CineEnCasa, construida a partir del prototipo de Figma.

## Descargar APK

[Descargar CineEnCasa.apk](https://uniandes-my.sharepoint.com/:u:/g/personal/jd_cuevas2_uniandes_edu_co/IQCUnCgi2CsASYr3Kds6y1tkAUJhc1Dzv434oyTISwKNUB8?e=le5Qv9)

## Requisitos
- JDK 17+
- Android SDK (compileSdk/targetSdk 36, minSdk 26)

## Compilar y verificar
```bash
./gradlew :app:assembleDebug
./gradlew :app:lintDebug
```

## Instalar en un dispositivo/emulador
```bash
./gradlew :app:installDebug
adb shell am start -n com.cineencasa.mobile/.MainActivity
```

## Pantallas

6 pantallas de contenido planeadas, más Login (7 en total):

| Pantalla | Figma | Descripción |
|---|---|---|
| Login | M-01 | Inicio de sesión. |
| Cartelera | M-03 | Explora películas en cartelera y suscríbete a una para crear su alarma. |
| Detalle | M-04 / M-05 | Sinopsis, ficha técnica y estado de la alarma (sin alarma / con alarma activa) de una película. |
| Confirmación de alarma | M-06 | Se muestra al crear una alarma nueva. |
| Mis alarmas | M-09 | Lista de películas con alarma activa. |
| Notificación — ¿aún te interesa? | M-12 | Aviso 1 día antes del estreno; confirma o cancela la alarma. |
| Notificación — ya disponible | M-13 | Aviso final (1 hora antes) cuando el título ya está disponible en streaming. |
