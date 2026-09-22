# CineEnCasa — Android

App Android (Kotlin + Jetpack Compose + Material 3) del proyecto CineEnCasa, construida a partir del prototipo de Figma.

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

Convenciones del proyecto, catálogo de pantallas y tokens de diseño: ver el `CLAUDE.md` local en la raíz del repo (no versionado).
