// const person ={
//     age:20
// };

// // person.name = "홍길동"
// Object.defineProperty(person, "name", {
//     value: "홍길동",
//     writable: false,
//     enumerable: true,
//     configurable: true
// })

// console.log(person);
// console.log(Object.getOwnPropertyDescriptor(person, 'name'));

// person.name = '아이유';
// console.log(person);

// console.log(Object.keys(person));

// // key
// for(let key in person){
//     console.log(person[key]);
// }

// for(let value of person){
//     console.log(value);
// }

//----------------------------------------------------------------------------------------

// const person1 = {}
// console.log(person1);

// const person2= new Object();
// console.log(person2);

//----------------------------------------------------------------------------------------

// function Person() {  

// }

// const person1 = Person();
// console.log(person1);            // function no return > undefined

// const person2 = new Person()    // this에 바인딩, 생성자는 return이 없음
// console.log(person2);           // Person {}, instance

// var person3 = {}                // litera;
// console.log(person3);           // {}

//----------------------------------------------------------------------------------------

// function Person() {  
//     // this keyword, 생성자 함수와 일반 함수일 때도 존재
//     // 생성자 함수에서의 this > 생성자 함수에 의해서 만들어질 instance를 가르키는 reference
//     // 일반 함수에서의 this > window in browser
//     console.log(this)
// }

// Person();

//----------------------------------------------------------------------------------------

// var obj = {
//     name:'홍길동'
// }
// console.dir(obj);

// function squre(number){
//     return number*number;
// }
// console.dir(squre);

//----------------------------------------------------------------------------------------

// // f는 callback
// // foo는 고차함수
// function foo(f){
//     return f();
// }

// function bar(){
//     // bar는 함수 이름
//     // 함수 이름은 함수 내부에서만 사용 가능
//     return 'caller : ' + bar.caller;
// }

// console.log(bar());
// console.log(foo(bar));

//----------------------------------------------------------------------------------------

var obj = {
    name:'홍길동'
}

function squre(number){
    return number*number;
}

console.dir(obj);
console.dir(squre);
