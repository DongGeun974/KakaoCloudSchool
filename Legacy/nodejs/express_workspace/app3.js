var express = require('express');

var app = express();

// get 방식 파라미터 처리
app.get("/userinfo", (request, response)=>{

    console.log(request.query);

    var name = request.query.name;
    var age = request.query.age;

    response.writeHead(200, {"Content-Type":"text/html"});
    response.end(`<h1>${name} ${age}</h1>`);
})

app.get("/array", (request, response)=>{

    console.log(request.query);

    var arr = request.query.arr;
    var result = "";
    for (i in arr)
    {
        result +=`${arr[i]}<br/>`
    }
    response.writeHead(200, {"Content-Type":"text/html"});
    response.end(result);
})

app.use((request, response)=>{
    response.status(404).send(`<h1>Error</h1>`)
})

app.listen(4000, ()=>{
    console.log("server start http://127.0.0.1:4000");
})