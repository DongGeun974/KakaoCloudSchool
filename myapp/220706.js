// var age  = 20;
// var obj = {
//     userName: 'hong gil dong',
//     getName:function(){
//         console.log('~');
//     },
//     setName(){                  // method, ES6
//         console.log('~');
//     },
//     age                         // 축약 표현
// }

//----------------------------------------------------------------------------------------

// // 'use strict';                   // 엄격한, 진지한, strict mode

// const person = {
//     name: 'Lee'
// };

// // 객체 확장 가능 여부 확인
// console.log(Object.isExtensible(person));

// person.age = 20
// console.log(person);            // { name: 'Lee', age: 20 }

// Object.preventExtensions(person)
// person.address = 'seoul'        // not working, but no error
//                                 // invoke error in strict mode
// console.log(person);            // { name: 'Lee', age: 20 }

// // 객체 확장 및 삭제
// Object.seal(person)
// delete person.name
// console.log(person);

// // 객체 동결
// Object.freeze(person);
// person.name = '아이유'
// console.log(person);

//----------------------------------------------------------------------------------------

// // 객체 literal
// const person1 = {}
// console.dir(person1);

// // 객체 Object 생성자 함수
// // instance
// const person2= new Object();
// console.dir(person2);

//----------------------------------------------------------------------------------------

// var tmp = String(true)
// console.log(tmp);

//----------------------------------------------------------------------------------------

// // 생성자 함수의 이름 식별자는 PascalCase
// function Person() {  

// }

// const person1 = Person();
// console.log(person1);            // function no return > undefined

// const person2 = new Person()    // this에 바인딩, 생성자는 return이 없음
// console.log(person2);           // Person {}, instance

// var person3 = {}                // litera;
// console.log(person3);           // {}

//----------------------------------------------------------------------------------------

// function Person(name) {  
//     // this keyword, 생성자 함수와 일반 함수일 때도 존재
//     // 생성자 함수에서의 this > 생성자 함수에 의해서 만들어질 instance를 가르키는 reference
//     // 일반 함수에서의 this > window in browser, global in nodejs
//     this.name = name;
//     this.getName = function () {  
//         return `내 이름은 ${this.name}입니다`;
//     }

//     // return {};       // 동작 안함
//     return 100;         // Primitive value를 리턴하는 경우에는 그 Primitive value는 무시되고, this가 return
//                         // 생성자 함수를 만들 때는 return 구문이 없어야 함
// }

// const person1 = new Person('아이유');
// const person2 = new Person('김연아');

// console.log(person1.getName());
// console.log(person2.getName());

//----------------------------------------------------------------------------------------

// function foo(){
// }

// foo.myName = '홍길동';
// foo.getName = function(){
//     console.log(this);
// }

// // foo()               // 함수 호출
// // new foo();          // 생성자 함수 호출
// foo.getName();      // method 호출

//----------------------------------------------------------------------------------------

// function foo(){
// }

// foo()               // 함수 호출, [[Call]]
// new foo();          // 생성자 함수 호출, [[Constructor]]

//----------------------------------------------------------------------------------------

// // [[Construtor]] 존재
// // Construtor
// function foo(){};

// var bar = function(){};

// // 객체의 property로 함수가 할당
// const barx = {
//     x:function(){}
// }

// new foo();      
// new bar();
// new barx.x();


// // [[Construtor]] 없음
// // non-Construtor
// const arrow = ()=>{};
// // new arrow();

// const obj = {
//     x(){}
// }
// // new obj.x();

//----------------------------------------------------------------------------------------

// // 함수 선언문
// function add(x,y){
//     return x+y;
// }

// var inst = new add();       // add {}
// console.log(inst);

// function createUser(name, role) {  
//     return {name, role};        // 축약 표현, 객체
// }

// var inst = new createUser();
// console.log(inst);

// // 생성자 함수
// function Circle(radius) {  
//     this.radius= radius;
//     this.getDiameter = function(){
//         return 2*this.radius;
//     }
// }

// // function call 일때, this는 global object
// const circle = Circle(5);

// console.log(radius);        // 5
// console.log(circle);        // undefined       

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

// console.log(bar());         // null
// console.log(foo(bar));      // foo

//----------------------------------------------------------------------------------------

// var obj = {
//     name:'홍길동'
// }

// function squre(number){
//     return number*number;
// }

// console.dir(obj);
// console.dir(squre);

//----------------------------------------------------------------------------------------

// // 생성자 함수로 사용할 목적
// // 함수 선언문
// function Person(name){
//     // 생성자 함수로 만들어질 instance가 가지는 property 설정
//     this.name = name;
// }

// const person1 = new Person('홍길동');
// // person.name
// // console.log(person.age);     // 해당 객체가 key가 없으면 prototype에서 찾음
// const person2 = new Person('김길동');

//----------------------------------------------------------------------------------------

// // 생성자 함수
// function Circle(radius){
//     this.radius = radius;
//     // 객체마다 따로 만듦
//     this.getDiameter = function(){
//         return 2*this.radius;
//     }
// }

// const circle1 = new Circle(5);
// const circle2 = new Circle(10);

// // 메모리 낭비
// console.log(circle1.getDiameter === circle2.getDiameter);        // false

//----------------------------------------------------------------------------------------

// // 생성자 함수
// function Circle(radius){
//     this.radius = radius;
//     // 객체마다 따로 만듦
//     // this.getDiameter = function(){
//     //     return 2*this.radius;
//     // }
//     // 상속 개념
//     Circle.prototype.getDiameter = function(){
//         return 2*this.radius;
//     }
// }

// const circle1 = new Circle(5);
// const circle2 = new Circle(10);

// // 메모리 낭비
// console.log(circle1.getDiameter === circle2.getDiameter);           // true

//----------------------------------------------------------------------------------------

// // 생성자 함수
// function Circle(radius){
//     this.radius = radius;
    
//     Circle.prototype.getDiameter = function(){
//         return 2*this.radius;
//     }

//     // 공용 변수
//     Circle.prototype.name = '홍길동'
// }

// const circle1 = new Circle(5);
// const circle2 = new Circle(10);
// console.log(circle1.name, circle2.name);

// // property가 없으면 생성, prototype chain하지 않음
// // circle1.name = '아이유'
// // Circle.prototype.name = '아이유'
// circle1.__proto__.name = '아이유'
// console.log(circle1.name, circle2.name);

//----------------------------------------------------------------------------------------

// function foo1(...args, param1){}
// function foo2(...args1, ...args2){}

function foo(param1, ...args){

    // [Arguments] { '0': 1, '1': 2, '2': 3, '3': 4, '4': 5 }
    console.log(arguments);

    // ...args : rest parameter
    // [ 1, 2, 3, 4, 5 ]
    console.log(args);

    return args.pop();
}

foo(1,2,3,4,5)
