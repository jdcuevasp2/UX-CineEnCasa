document.addEventListener('DOMContentLoaded', function(){
  const form = document.getElementById('loginForm');

  form.addEventListener('submit', function(e){
    e.preventDefault();
    try{ localStorage.setItem('cine_logged', '1'); }
    catch(err){ console.warn('No se pudo guardar la sesión en localStorage', err); }
    // ?logged=1 viaja en la URL: Firefox aisla localStorage por archivo bajo file://
    window.location.href = 'calendar.html?logged=1';
  });
});
