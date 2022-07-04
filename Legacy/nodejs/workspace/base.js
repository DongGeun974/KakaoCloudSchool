let http = require('http');
const url = require("url");
const fs = require("fs");

var server = http.createServer(function(request, respose){
    var pathName = url.parse(request.url).pathname;

    respose.statusCode = 200;            
    respose.setHeader("Content-type","text/html");
    respose.end('<h1>Hello world!</h1>');          
})

server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000");
});                                        