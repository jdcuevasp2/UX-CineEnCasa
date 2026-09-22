// Vista: Login (index.html) — requiere correo y contraseña no vacíos (prototipo, acepta cualquier valor)
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
    const emailValid = email.value.trim().length > 0;
    const passwordValid = password.value.trim().length > 0;
    setFieldError(email, !emailValid);
    setFieldError(password, !passwordValid);
    if(!emailValid || !passwordValid){
      (emailValid ? password : email).focus();
      return;
    }
    localStorage.setItem('cine_logged', '1');
    window.location.href = 'calendar.html';
  });
});

