let promise = new Promise(function(resolve, reject){
    let data = {"name" : "hong", "age":23, "phone":"010-2111-2222"}
    // setTimeout(()=>resolve(10), 1000);
    // 1초 후 작업 성공 알리는 명령어를 호출
    // setTimeout(()=>resolve(data), 1000);
    setTimeout(()=>{
        s=0;
        for(i=1; i<=100;i++)
        {
            s+=i;
        }
        resolve(s);     // resolve의 함수에 전달되는 값이 then 구문의 콜백함수의 매개변수로 전달
    }, 1000);

}).then((val)=>{
    console.log(val)
}).catch((error)=>{
    console.log(error)  //reject("error")
}).finally(()=>{
    console.log("----------------------end----------------------")
})

console.log(promise);
