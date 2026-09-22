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

  const STORAGE_KEY = 'cine_notification_prefs';
  const checkboxes = Array.from(document.querySelectorAll('.pref-row input[type="checkbox"]'));

  try{
    const saved = JSON.parse(localStorage.getItem(STORAGE_KEY) || 'null');
    if(Array.isArray(saved)){
      checkboxes.forEach(function(cb, i){
        if(typeof saved[i] === 'boolean'){ cb.checked = saved[i]; }
      });
    }
  }catch(err){ console.warn('No se pudieron leer las preferencias guardadas', err); }

  const saveBtn = document.getElementById('saveBtn');
  const savedMsg = document.getElementById('savedMsg');
  let savedMsgTimeout;

  saveBtn.addEventListener('click', function(){
    const values = checkboxes.map(function(cb){ return cb.checked; });
    try{ localStorage.setItem(STORAGE_KEY, JSON.stringify(values)); }
    catch(err){ console.warn('No se pudieron guardar las preferencias', err); }

    savedMsg.hidden = false;
    window.clearTimeout(savedMsgTimeout);
    savedMsgTimeout = window.setTimeout(function(){ savedMsg.hidden = true; }, 2000);
  });
});
