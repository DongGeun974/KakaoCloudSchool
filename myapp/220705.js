// var obj = {
//     'name': 'hong gil dong',
//     'printName': function myPrint(){
//         console.log(`내 이름은 ${this.name}입니다.`);
//     },
//     "!myPhone" : '010-1234-5678',
//     10:300      // '10'
// }


// console.log(typeof obj);
// obj.printName();
// console.log(obj.printName);
// console.log(obj);

//----------------------------------------------------------------------------------------

// var obj = {
//     'name': 'hong gil dong',
// }

// obj.myAge = 20;
// obj['!myPhone'] = '010-1234-5678'
// console.log(obj);

// delete obj.myAge
// console.log(obj);

//----------------------------------------------------------------------------------------

// var obj = {
//     10: 100,
//     let: '가능하지만 권장되지 않음',
//     myName: '홍길동',
//     '!myName' : '김길동',
//     myName: '김연아',
// }
// console.log(obj);
// console.log(obj.myAddress);         // undefined

//----------------------------------------------------------------------------------------

// let x = 1;
// let y = 2;

// const obj = {x,y}           // 확장표현방식

// // let myObj = {
// //     name : '홍길동',
// //     printName : function(){
// //         console.log(this.name);
// //     }
// // }

// let myObj = {
//     name : '홍길동',
//     printName(){                        // javascript method
//         console.log(this.name);
//     },
//     test
// }
// myObj.printName()

//----------------------------------------------------------------------------------------

// let myStr = 'hello';
// // primitive type을 마치 객체(배열)처럼 사용
// // 새로운 객체 생성
// // 내부 슬롯
// // 유사 배열 객체
// // console.log(myStr[0]);      // h
// // console.log(myStr.length);  // 5
// myStr[0] = "H"
// console.log(myStr);

//----------------------------------------------------------------------------------------

// let person = {name:"lee"}
// let copy = person           // 주소값 복사, side effect

//----------------------------------------------------------------------------------------

// var myFunc = function add(x,y) {  
//     return x+y
// }

// // console.log(add(3,5));      // add is not defined
// console.log(myFunc(3,5));

//----------------------------------------------------------------------------------------

// // 함수 선언문
// // 함수 호이스팅 발생
// // 엔진이 묵시적으로 함수 이름과 똑같은 변수를 만듦
// // 미리 객체가 만들어져서 할당됨
// function foo() {  
//     console.log('foo function');
// }

// // 함수 literal
// // () : 내부연산
// (function bar(){
//     console.log('bar function');
// })

// foo();
// // bar();

//----------------------------------------------------------------------------------------

// foo();                              // 호출 가능
// // add();                              // add is not a function

// // 함수 선언문
// // runtime 이전에 식별자 할당
// // hoisting 문제 발생
// function foo() {  
//     console.log('foo function');
// }


// // 함수 표현식
// // runtime 이후 할당
// // add는 재할당
// // 프로그래밍에서 상식적인 방법
// var add = function bar(){
//     console.log('bar function');
// }

//----------------------------------------------------------------------------------------

// // 함수 선언문
// function add(){
//     // arguments 객체 존재, call 할 때 넘어오는 인자를 가지고 있음
//     // 유사 배열 객체(Array-like Object)
//     // length property를 가지고 배열처럼 index를 이용해서 access 가능, 순환 가능
//     let sum = 0;
//     for (let i = 0; i <arguments.length; i++)
//     {
//         sum+=arguments[i];
//     }
//     return sum;
// }

// console.log(add(2,5));
// console.log(add(2));        // y = undefined, 호출 가능, result = NaN
// console.log(add(2,3,4));    // 호출 가능

//----------------------------------------------------------------------------------------

// // IIFE(즉시 실행 함수)
// // 객체 literal로 인식
// (function (){
//     let x = 10;
//     let y = 20;

//     console.log(x+y);
// }());

//----------------------------------------------------------------------------------------

// // 잘 만든 함수가 존재
// // 그런데 이 함수의 기능을 변경(추가)
// // 1. 원래 있는 함수를 수정
// // 2. 함수를 새로 추가
// // 3. 함수를 추상화시켜서 인자로 받아서 사용
// function repeat(n, f){              // repeat는 고차함수, f는 추상화
//     for (var i = 0; i<n; i++)
//     {
//         f(i)
//     }
// }

// // callback function
// let logAll = function(i){
//     console.log(i);
// }

// // callback function
// let logOdd = function(i){
//     if (i%2){
//         console.log(i);
//     }
// }

// repeat(5, logOdd);

//----------------------------------------------------------------------------------------

// var x = 1;              // 전역 scope의 전역 변수

// function foo(){
//     var x = 10;         // 지역 scope의 지역 변수
//     bar();
// }

// function bar(){
//     console.log(x);
// }

// foo();

//----------------------------------------------------------------------------------------

// Property Attribute 확인
// const person = {
//     name : "Lee",
//     age : 20
// }

// // 내부 slot으로 직접적인 접근 불가
// console.log(Object.getOwnPropertyDescriptor(person, 'age'));
// console.log(Object.getOwnPropertyDescriptors(person));

//----------------------------------------------------------------------------------------

const person ={};

// person.name = "홍길동"
Object.defineProperty(person, "name", {
    value: "홍길동",
    writable: false,
    enumerable: false,
    configurable: true
})

console.log(person);
console.log(Object.getOwnPropertyDescriptor(person, 'name'));

//----------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------