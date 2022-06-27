exports.abs = function(number){
    if(number > 0)
    {
        return number;
    }else
    {
        return -number;
    }
}

function isLeap(s){
    if (s%4==0 && s%100!=0 || s%400==0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

function hello(){
    return "hello nodejs";
}

// 외부로 모듈을 노출시켜야 다른 모듈에서 접근 가능
// exports.키 = 함수
exports.isLeap = isLeap;
exports["test"] = hello;