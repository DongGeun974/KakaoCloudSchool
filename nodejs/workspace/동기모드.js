var fs = require("fs");

try{
    var data = fs.readFileSync("./nodejs/workspace/hello.js", "utf-8");
    console.log(data);
}catch(e)
{
    console.log(e);
}

console.log("............end.............");