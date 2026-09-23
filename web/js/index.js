document.addEventListener('DOMContentLoaded', function(){
  const form = document.getElementById('loginForm');

  form.addEventListener('submit', function(e){
    e.preventDefault();
    try{ localStorage.setItem('cine_logged', '1'); }
    catch(err){ console.warn('No se pudo guardar la sesión en localStorage', err); }
    // ?logged=1 viaja en la URL: Firefox aisla localStorage por archivo bajo file://
    // Primero mostramos el estado vacío del calendario; calendar-empty.js se
    // encarga de pasar a calendar.html a los pocos segundos.
    window.location.href = 'calendar-empty.html?logged=1';
  });
});
