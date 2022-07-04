let http = require('http');
const url = require("url");
const fs = require("fs");

var server = http.createServer(function(request, respose){
    var pathName = url.parse(request.url).pathname;

    // url에 따라서 다르게 동작
    // routing
    if(pathName == "/")
    {
        respose.statusCode = 200;            
        respose.setHeader("Content-type","text/html");
        respose.end('<h1>Hello world!</h1>');          
    }else if(pathName == "/test")
    {
        respose.statusCode = 201;            
        respose.setHeader("Content-type","text/html");
        respose.end('<h1>Test</h1>');          
    }else
    {
        respose.statusCode = 200;            
        respose.setHeader("Content-type","text/html; charset=utf-8");
        respose.end('<h1>잘못된 url입니다.</h1>');          
    }
    
})

server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000");
});                                        


/*
    문제1 : http://127.0.0.1:3000/hello?name=Jane >> hello Jane
    문제2 : http://127.0.0.1:3000/add?x=7&y=10 >> 17
    문제3 : http://127.0.0.1:3000/gugu?dan=4 >> 4단 출력
    문제4 : http://127.0.0.1:3000/rect?width=4&height=10 >> 4 x 10 사각형
*/