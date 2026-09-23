// Header compartido por todas las vistas autenticadas. Se define como un
// elemento personalizado (sin fetch, sin build) para que funcione igual
// abriendo el archivo directo con file:// que sirviéndolo con un servidor.
// Uso: <app-header class="app-header"></app-header> + este script en <head>.
(function(){
  function headerMarkup(){
    return ''
      + '<div class="app-header__inner">'
      +   '<a href="calendar.html?logged=1" class="brand">'
      +     '<img src="assets/d3d3d.svg" alt="" class="brand-icon"/>'
      +     '<span class="brand-title">CineEnCasa</span>'
      +   '</a>'
      +   '<div class="header-actions">'
      +     '<a href="notification-preferences.html?logged=1" title="Preferencias de notificación">'
      +       '<span class="material-symbols-outlined header-icon" aria-label="Preferencias de notificación">notifications</span>'
      +     '</a>'
      +     '<a href="profile.html?logged=1" title="Perfil">'
      +       '<span class="material-symbols-outlined header-icon" aria-label="Perfil">account_circle</span>'
      +     '</a>'
      +   '</div>'
      + '</div>';
  }

  class AppHeader extends HTMLElement {
    connectedCallback(){
      this.innerHTML = headerMarkup();
    }
  }

  if(!customElements.get('app-header')){
    customElements.define('app-header', AppHeader);
  }
})();
