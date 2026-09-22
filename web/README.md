# CineEnCasa — Web

Prototipo web estático (HTML/CSS/JS, sin frameworks ni dependencias) de las pantallas de CineEnCasa.

## Requisitos

- Un navegador moderno (Chrome, Firefox, Edge, Safari).
- No requiere Node, npm ni ningún gestor de paquetes — no hay build ni instalación.
- Opcional: cualquier servidor estático simple (Python, `npx serve`, extensión "Live Server" de VS Code, etc.) si prefieres no abrir los archivos directamente con `file://`.

## Cómo abrir el proyecto

### Opción 1 — Abrir `index.html` directamente (más simple)

1. Entra a la carpeta `web/`.
2. Haz doble clic en `index.html` (o ábrelo desde el navegador con `Archivo > Abrir`).
3. Inicia sesión y navega normalmente.

> Nota: bajo `file://` el `fetch` a `data/events.json` puede fallar por restricciones del navegador; el calendario ya contempla esto con un JSON de respaldo embebido en `calendar.html`, así que igual funciona sin servidor.

### Opción 2 RECOMENDADA — Servir con un servidor local

Desde la carpeta `web/`, usa cualquiera de estas alternativas y abre la URL que te indique (normalmente `http://localhost:8000` o similar):

```bash
# Con Python 3
python3 -m http.server

# Con Node (sin instalar nada globalmente)
npx serve .
```

## Inicio de sesión (prototipo)

La pantalla de login (`index.html`) acepta **cualquier correo y contraseña no vacíos** — es un prototipo y no valida credenciales reales contra un backend.

Ejemplo de datos para probar:

- Correo: `demo@cineencasa.com`
- Contraseña: `demo1234`

## Estructura

- `index.html` — Login.
- `calendar.html` — Calendario de estrenos/alarmas (requiere sesión).
- `detail.html` — Detalle de alarma/título (requiere sesión).
- `cancel-alarm.html` — Modal de confirmación para cancelar una alarma (requiere sesión).
- `profile.html` — Perfil / gestión de cuenta (requiere sesión).
- `css/` — Estilos, incluyendo `material-tokens.css` con los tokens Material 3 compartidos.
- `js/` — Lógica de cada vista (sesión, render de calendario, interacciones).
- `data/events.json` — Eventos mostrados en el calendario.
- `assets/` — Imágenes/SVG exportados desde Figma.
