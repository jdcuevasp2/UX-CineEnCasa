document.addEventListener('DOMContentLoaded', function(){
  const form = document.getElementById('loginForm');
  const email = document.getElementById('email');
  const password = document.getElementById('password');

  function setFieldError(input, hasError){
    input.closest('.md3-field').classList.toggle('md3-field--error', hasError);
  }

  [email, password].forEach(function(input){
    input.addEventListener('input', function(){ setFieldError(input, false); });
  });

  form.addEventListener('submit', function(e){
    e.preventDefault();
    setFieldError(email, false);
    setFieldError(password, false);
    try{ localStorage.setItem('cine_logged', '1'); }
    catch(err){ console.warn('No se pudo guardar la sesión en localStorage', err); }
    // ?logged=1 viaja en la URL: Firefox aisla localStorage por archivo bajo file://
    window.location.href = 'calendar.html?logged=1';
  });
});

