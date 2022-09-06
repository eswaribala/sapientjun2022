var express = require("express");
var fs = require('fs')
var bodyParser =require("body-parser");
var cors=require("cors");
const log = require("log-to-file");
var app = express();
app.use(cors());
//app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json())

app.get("/policies", function(request, response) {
    response.send("Testing Express ....!");
});
app.post('/policy',function(request,response)
{
    console.log("Testing...")
    response.setHeader('Access-Control-Allow-Origin', '*');
    response.setHeader('Access-Control-Allow-Methods', 'GET, POST');
    response.header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
    response.setHeader('Access-Control-Allow-Credentials', true);
    console.log(request.body);
    //console.log(request);


    response.end("Object received successfully");

});
app.post('/writetolog',function(request,response)
{
    console.log("Testing...")
    response.setHeader('Access-Control-Allow-Origin', '*');
    response.setHeader('Access-Control-Allow-Methods', 'GET, POST');
    response.header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
    response.setHeader('Access-Control-Allow-Credentials', true);
    console.log(request.body.data);


// Save log to default log file "default.log".
    log(request.body.data);

// Save log to custom log file "my-log.log".
    log(request.body.data, 'my-log2022.log');

// Save log to custom log file "my-log.log" with delimiter "\r\n" (default delimiter "\n").
    log(request.body.data, 'my-log2021.log', '\r\n');



    response.end("Object received successfully");

});



app.set('port',4000);
app.listen(app.get('port'), function(){
    console.log('The server is running, ' +
        ' please open your browser at http://localhost:%s',
        app.get('port'));
});

