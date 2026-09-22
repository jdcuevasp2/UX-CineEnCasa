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
  logoutBtn.addEventListener('click', function(){
    try{ localStorage.removeItem('cine_logged'); }
    catch(err){ console.warn('No se pudo borrar la sesión de localStorage', err); }
    window.location.href = 'index.html';
  });
});
