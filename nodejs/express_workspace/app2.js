var express = require('express');

var app = express();

app.use("/", (req, res)=>{
    var agent = req.header("User-Agent");
    console.log(agent);
    
    // match(/pattern/) - 정규식
    if(agent.toLowerCase().match(/chrome/) && !agent.toLowerCase().match(/edg/))
    {
        res.send("agent is 크롬");    
    }
    else{
        res.send("agent is not 크롬");    
    }
})

app.get("/test", (request, response)=>{
    response.writeHead(200, {"Content-Type":"text/html"});
    response.end(`<h1>get test</h1>`);
})

app.get("/data", (request, response)=>{
    response.send({name:"hong", age:12, phone:"010-0000-1111"})
})

app.get("/msg", (request, response)=>{
    // response.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
    response.send(`<h1>안녕하세요 express 입니다.</h1>`);
})

app.post("/test", (request, response)=>{
    response.writeHead(200, {"Content-Type":"text/html"});
    response.end(`<h1>post test</h1>`);
})

app.use((request, response)=>{
    response.status(404).send(`<h1>Error</h1>`)
})

app.listen(4000, ()=>{
    console.log("server start http://127.0.0.1:4000");
})