// const myArr = [1, 2, 3];

// myArr.forEach(function(data, idx){
//     console.log(data);
//     console.log(idx);
// })

//----------------------------------------------------------------------------------------

// console.log(score);     // undefined
// var score;

//----------------------------------------------------------------------------------------

// var x = 1;
// var y = 2;

// // var keyword로 변수의 중복 선언이 가능
// var x = 100;    // 가능, var keyword가 없는 것처럼 동작
// var y;          // 가능, 초기화 구문이 없으면 무시

//----------------------------------------------------------------------------------------

// var x = 1;          // 전역변수
// if (true)
// {
//     var x = 100;    // 변수 재정의
// }
// console.log(x);     // 100

// var i = 100;
// for(var i = 0; i<5; i++)
// {
//     console.log(i);
// }
// console.log(i);

//----------------------------------------------------------------------------------------

// var x = 1;          // 전역변수
// function myFunc(){
//     var x = 100;    // function-level scope가 다름
//     console.log(x); // 100
// }
// function myFunc2(){
//     console.log(x); // hoisting, undefined
//     var x = 100;    
// }
// console.log(x);     // 1
// myFunc();
// myFunc2();

//----------------------------------------------------------------------------------------

// let x = 100;
// let x = 1;

//----------------------------------------------------------------------------------------

// let score = 100;

// {
//     let score = 10;
//     let myVar = 1;
// }
// console.log(myVar);

//----------------------------------------------------------------------------------------

// console.log(myVar);

// let myVar = 1;

// let myVar = 1;      // global variable
// {
//     console.log(myVar);     // ReferenceError: Cannot access 'myVar' before initialization
//     let myVar = 100;
// }

//----------------------------------------------------------------------------------------

// let myVar = 1.0;

// console.log(myVar === 1);       // '===', 타입까지 비교

// console.log(3/2);

//----------------------------------------------------------------------------------------

// let str = '이것은 \n소리없는 \n아우성';

// console.log(str);

// let str1 = `이것은
// 소리없는
// 아우성`

// console.log(str1);

//----------------------------------------------------------------------------------------

// let name1 = '홍길동';

// console.log('내 이름은 ' + name1 + '입니다.');
// console.log(`내 이름은 ${name1}입니다.`);

//----------------------------------------------------------------------------------------

// const mySymbol = Symbol();
// console.log(typeof mySymbol);
// console.log(mySymbol);


// const mySymbol1 = Symbol('test');           // descriptor
// const mySymbol2 = Symbol('test');
// console.log(mySymbol1 === mySymbol2);       // false
// console.log(mySymbol1.description);       

// if (mySymbol1)
// {
//     console.log("존재");
// }

// global symbol registry
// 거기에서 해당 인자를 키로 가지고 있는 symbol 찾음
// 만약 존재하지 않으면 symbol 만듦
// global symbol registry에 등록하고 symbol 리턴
// const s1 = Symbol.for('mySymbol')
// const s2 = Symbol.for('mySymbol')
// console.log(s1===s2);               // true

// console.log(Symbol.keyFor(s2))

//----------------------------------------------------------------------------------------

// const Direction = {
//     'up':Symbol(),
//     'down':Symbol(),
//     'left':Symbol(),
//     'right':Symbol()
// }
// let myDirection = Direction.down;
// if (myDirection == Direction.down)
// {
    
// }

//----------------------------------------------------------------------------------------

// console.log(1+2);       // 3
// console.log(1 + '2');   // '12'
// console.log(1 + true);      // 2
// console.log(true + "2");    // 'true2'
// console.log(1 + null);      // 1
// console.log(1 + undefined); // NaN

//----------------------------------------------------------------------------------------

console.log(typeof String(1));
console.log(typeof String(NaN));
console.log(typeof (1).toString());