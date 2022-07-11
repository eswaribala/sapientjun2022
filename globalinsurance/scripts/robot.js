var found = 0;
var n = 1;
var total = 0;
var THRESHOLD = 800000000;


while (total < THRESHOLD) {
    n += 1;
    for (var i = 2; i <= Math.sqrt(n); i++) {
        if (!(n % i == 0)) {
			total++;

            setTimeout(postMessage(found),5000000) ;
        }
        else {
            found++;
        }
    }
}
