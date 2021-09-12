var ta;
var ws = null;
var bstart;
var bstop;
var supportsWebSockets = 'WebSocket' in window || 'MozWebSocket' in window;


window.onload = function () {
    if (supportsWebSockets) {
        WriteMessage('support', 'Yes');
        ta = document.getElementById('ta');
        bstart = document.getElementById('bstart');
        bstop = document.getElementById('bstop');
        bstart.disabled = false;
        bstop.disabled = true;
    } else {
        WriteMessage('support', 'No');
    }
}

function WriteMessage(idspan, txt) {
    var span = document.getElementById(idspan);
    span.innerHTML = txt;
}

function exe_start() {
    if (ws == null) {
        ws = new WebSocket("ws://localhost:8888/Websockets.websocket");
        ws.onopen = () => ws.send('Connection')
        ws.onclose = (s) => console.log('onclose', s);
        ws.onmessage = (e) => ta.innerHTML += '\n' + e.data;
        bstart.disabled = true;
        bstop.disabled = false;
    }
}

function exe_stop() {
    ws.send("stop");
    ws.close(3001);
    ws = null;
    bstart.disabled = false;
    bstop.disabled = true;
}