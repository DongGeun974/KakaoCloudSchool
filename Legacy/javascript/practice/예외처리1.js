let json = "{bad json}";

try{
    let user = JSON.parse(json);
    alert(user.name);
}catch(e){
    console.log(e.message);
}finally{
    console.log("반드시 거침")
}