document.addEventListener('DOMContentLoaded', function(){
  const loggedParam = new URLSearchParams(window.location.search).get('logged') === '1';
  let hasSession = loggedParam;
  try{
    if(loggedParam){ localStorage.setItem('cine_logged', '1'); }
    else { hasSession = !!localStorage.getItem('cine_logged'); }
  }catch(err){ console.warn('No se pudo leer la sesión de localStorage', err); }
  if(!hasSession){
    window.location.href = 'index.html';
    return;
  }

  // Prototipo/demo: simula que el calendario termina de cargar y ya trae
  // los estrenos seguidos, pasando automáticamente a calendar.html.
  window.setTimeout(function(){
    window.location.href = 'calendar.html?logged=1';
  }, 3000);
});
