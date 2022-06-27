let http = require('http');
const fs = require("fs");
const url = require("url")

var server = http.createServer(function(request, respose){
    var pathname = url.parse(request.url).pathname;
    // http://127.0.0.1:3000?name=tm&age=33

    if (request.method=="GET" && pathname == "/")
    {
        console.log(request);
        var query = url.parse(request.url, true).query;     // 쿼리를 파싱해서 json으로 수정
        console.log(query)
        console.log(query.name, query.age)
        console.log(query["name"], query["age"])

        var data = fs.readFileSync("./nodejs/workspace/html/index.html", "utf-8");

        respose.statusCode = 200;                           // 성공 코드
        respose.setHeader("Content-type","text/html");      // html set
        respose.end(data);          
    }

    
    else if(request.method == "POST")  
    {
        // console.log(pathname);
        request.on("data",(data)=>{
            respose.statusCode = 200;                           // 성공 코드
            respose.setHeader("Content-type","text/html;");      // html set
            
            respose.end('<h1>'+data+'</h1>');          
        })
    }
})

server.listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000");
});                                        // 3000포트 사용