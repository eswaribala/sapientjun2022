/**
 * Created by BALASUBRAMANIAM on 30-11-2015.
 */
var worker = new Worker('scripts/robot.js');
var width = 0;
var counter = 0;
var percentage = 0;
worker.postMessage(10000);


worker.onmessage = function (event) {
    counter++;

    var prime = document.getElementById('prime');
    prime.innerHTML = 'Prime found: ' + event.data;

    if (counter % 100 == 0) { // ---> Update progressbar.
        setTimeout( percentage++,10000);
        setTimeout( width+=3,10000);
        var progressbar = document.getElementById('progressbar');
        progressbar.innerHTML = percentage + '%';
        progressbar.style.width = width + 'px';
    }
};
