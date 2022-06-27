let http = require('http');
http.createServer(function(request, respose){
    // respose.writeHead(200, {'Content-Type':'text/html'});
    // respose.end('<h1>Hello world!</h1>');

    // 클라이언트로부터 연결 요청이 오면 이 함수 호출
    respose.statusCode = 200;                           // 성공 코드
    respose.setHeader("Content-type","text/html");      // html set
    respose.end('<h1>Hello world!</h1>');          
}).listen(3000, "127.0.0.1", ()=>{
    console.log("Server start at http://127.0.0.1:3000");
});                                        // 3000포트 사용