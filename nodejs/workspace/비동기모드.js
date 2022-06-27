var fs = require("fs");


fs.readFile("./nodejs/workspace/hello.js", "utf-8", function(error, data){
    // 에러가 있을 때, 객체가 만들어져서 전달
    if (error)
    {
        console.log(error);
        return;
    }
    console.log(data);
})

console.log("............end.............");