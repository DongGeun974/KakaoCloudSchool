var express = require('express');

var app = express();

app.get("/", (request, response)=>{
    response.writeHead(200, {"Content-Type":"text/html"});
    response.end(`<h1>get test</h1>`);
})


app.use((request, response)=>{
    response.status(404).send(`<h1>Error</h1>`)
})

app.listen(4000, ()=>{
    console.log("server start http://127.0.0.1:4000");
})