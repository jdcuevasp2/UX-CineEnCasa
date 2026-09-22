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

  // Botones "Semana/Día/Año" son solo visuales en este prototipo; "Mes" es la única vista implementada
  document.querySelectorAll('.seg-btn').forEach(function(btn){
    btn.addEventListener('click', function(){
      document.querySelectorAll('.seg-btn').forEach(b => b.classList.remove('is-selected'));
      btn.classList.add('is-selected');
    });
  });

  const root = document.getElementById('calendarRoot');
  const monthLabel = document.getElementById('monthLabel');
  const prevBtn = document.getElementById('prevMonth');
  const nextBtn = document.getElementById('nextMonth');

  const today = new Date();
  let sampleEvents = [];

  async function loadEvents(){
    try{
      const res = await fetch('data/events.json', {cache: 'no-store'});
      if(res.ok){
        const json = await res.json();
        sampleEvents = json.events || [];
        return;
      }
      throw new Error('fetch failed');
    }catch(e){
      // fallback: JSON embebido en la página (funciona con file://)
      try{
        const el = document.getElementById('events-json');
        if(el){ const json = JSON.parse(el.textContent); sampleEvents = json.events || []; return; }
      }catch(err){
        console.warn('No se pudo leer el JSON embebido de eventos', err);
      }
      console.warn('No se pudo cargar data/events.json, continuando sin eventos remotos', e);
    }
  }

  let viewDate = new Date(today.getFullYear(), today.getMonth(), 1);

  function render(){
    root.innerHTML = '';
    const year = viewDate.getFullYear();
    const month = viewDate.getMonth();
    const firstDay = new Date(year, month, 1);
    const lastDay = new Date(year, month+1, 0);
    const startWeekday = (firstDay.getDay() + 6) % 7; // Lunes=0 .. Domingo=6

    const monthNames = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
    monthLabel.textContent = monthNames[month] + ' ' + year;

    const table = document.createElement('div');
    table.className = 'calendar-table';

    const weekdays = ['L','M','M','J','V','S','D'];
    const head = document.createElement('div'); head.className='calendar-row calendar-weekdays';
    weekdays.forEach(w=>{ const c=document.createElement('div'); c.className='calendar-cell weekday'; c.textContent = w; head.appendChild(c); });
    table.appendChild(head);

    let cells = [];
    for(let i=0;i<startWeekday;i++){ cells.push(null); }
    for(let d=1; d<= lastDay.getDate(); d++){ cells.push(new Date(year, month, d)); }

    for(let r=0; r< Math.ceil(cells.length/7); r++){
      const row = document.createElement('div'); row.className='calendar-row';
      for(let c=0;c<7;c++){
        const idx = r*7 + c;
        const dayCell = document.createElement('div'); dayCell.className='calendar-cell';
        const cellVal = cells[idx];
        if(!cellVal){ dayCell.classList.add('empty'); }
        else{
          const iso = cellVal.toISOString().slice(0,10);
          const number = document.createElement('div'); number.className='day-number'; number.textContent = cellVal.getDate();
          dayCell.appendChild(number);
          const isToday = cellVal.toDateString() === today.toDateString();
          if(isToday) dayCell.classList.add('today');
          const events = sampleEvents.filter(ev => ev.date === iso);
          if(events.length){
            const isAlarm = events.some(ev => /alarma/i.test(ev.title));
            const chip = document.createElement('button');
            chip.type = 'button';
            chip.className = 'event-chip';
            chip.textContent = isAlarm ? 'Alarma' : 'Aviso';
            chip.addEventListener('click', function(e){
              e.stopPropagation();
              window.location.href = 'detail.html?logged=1';
            });
            dayCell.appendChild(chip);
            dayCell.title = events.map(e=>e.title).join('\n');
          }
        }
        row.appendChild(dayCell);
      }
      table.appendChild(row);
    }
    root.appendChild(table);
  }

  prevBtn.addEventListener('click', function(){ viewDate = new Date(viewDate.getFullYear(), viewDate.getMonth()-1, 1); render(); });
  nextBtn.addEventListener('click', function(){ viewDate = new Date(viewDate.getFullYear(), viewDate.getMonth()+1, 1); render(); });

  loadEvents().then(()=> render());
});

