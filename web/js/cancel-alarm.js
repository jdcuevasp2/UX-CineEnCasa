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

  const logoutBtn = document.getElementById('logoutBtn');
  logoutBtn.addEventListener('click', function(e){
    e.preventDefault();
    try{ localStorage.removeItem('cine_logged'); }
    catch(err){ console.warn('No se pudo borrar la sesión de localStorage', err); }
    window.location.href = 'index.html';
  });

  const noBtn = document.getElementById('noBtn');
  noBtn.addEventListener('click', function(){
    window.location.href = 'calendar.html?logged=1';
  });

  const yesBtn = document.getElementById('yesBtn');
  yesBtn.addEventListener('click', function(){
    // Prototipo/demo: al confirmar, esta era la única alarma seguida,
    // así que el calendario queda vacío.
    window.location.href = 'calendar-empty.html?logged=1';
  });
});
