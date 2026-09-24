# CineEnCasa — Web

Prototipo web estático (HTML/CSS/JS, sin frameworks ni dependencias) de las pantallas de CineEnCasa.

## Requisitos

- Un navegador moderno (Chrome, Firefox, Edge, Safari).
- No requiere Node, npm ni ningún gestor de paquetes — no hay build ni instalación.
- Opcional: cualquier servidor estático simple (Python, `npx serve`, extensión "Live Server" de VS Code, etc.) si prefieres no abrir los archivos directamente con `file://`.

## Cómo abrir el proyecto

### Opción 1 RECOMENDADA — Servir con un servidor local

Desde la carpeta `web/`, usa cualquiera de estas alternativas y abre la URL que te indique (normalmente `http://localhost:8000` o similar):

```bash
# Con Python 3
python3 -m http.server

# Con Node (sin instalar nada globalmente)
npx serve .
```

### Opción 2 — Abrir `index.html` directamente (más simple)

1. Entra a la carpeta `web/`.
2. Haz doble clic en `index.html` (o ábrelo desde el navegador con `Archivo > Abrir`).
3. Inicia sesión y navega normalmente.

> Nota: bajo `file://` el `fetch` a `data/events.json` puede fallar por restricciones del navegador; el calendario ya contempla esto con un JSON de respaldo embebido en `calendar.html`, así que igual funciona sin servidor.


## Inicio de sesión (prototipo)

La pantalla de login (`index.html`) acepta **cualquier valor, incluso vacío** — es un prototipo, no valida credenciales reales contra un backend.

Ejemplo de datos para probar:

- Correo: `demo@cineencasa.com`
- Contraseña: `demo1234`

## Estructura

- `index.html` — Login.
- `calendar.html` — Calendario de estrenos/alarmas (requiere sesión).
- `detail.html` — Detalle de alarma/título (requiere sesión).
- `cancel-alarm.html` — Modal de confirmación para cancelar una alarma (requiere sesión).
- `profile.html` — Perfil / gestión de cuenta (requiere sesión).
- `notification-preferences.html` — Preferencias de aviso (requiere sesión).
- `calendar-empty.html` — Estado vacío del calendario, cuando no se sigue ninguna película (requiere sesión).
- `css/` — Estilos, incluyendo `material-tokens.css` con los tokens Material 3 compartidos.
- `js/` — Lógica de cada vista (sesión, render de calendario, interacciones).
  - `js/app-header.js` — define `<app-header>`, el header compartido (marca, notificaciones, perfil) que usan todas las vistas autenticadas en vez de repetir el markup en cada HTML.
- `data/events.json` — Eventos mostrados en el calendario.
- `assets/` — Imágenes/SVG exportados desde Figma.
