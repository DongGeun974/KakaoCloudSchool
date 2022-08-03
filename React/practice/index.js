// 1
// Array.prototype.map()
// const array1 = [1,4,9,16]
// const map1 = array1.map(function(x){
//     return x*2
// })
// const map1 = array1.map((x)=>x*2)
// console.log(map1)
//////////////////////////////////////////////////////////////////////////////////////

// 2
// const words = ['세종대왕', '이황', '강감찬', '샤인머스켓', '소리없는 아우성']
// // 글자 길이가 3자를 초과하는 데이터만 추려서 새로운 배열 생성
// const result = words.filter((word) => {
//     return word.length > 3;
// })
// console.log(result);
//////////////////////////////////////////////////////////////////////////////////////

// 3
// 전개 연산자, Spread operator
// "..."
// let arr1 = [1,2,3]
// let arr2 = [4,5,6]
// let arr3 = [7,8,9]
// let result = [...arr1, ...arr2, ...arr3]
// console.log(result);
// let obj1 = {
//     a:'1',
//     b:'2'
// }
// let obj2 = {
//     c:'3',
//     d:'4'
// }
// result = {...obj1, ...obj2}
// console.log(result);
//////////////////////////////////////////////////////////////////////////////////////

// 4
// 구조분해할당(ES6)
// 코드 간결
// 객체나 배열의 속성을 분해해서 개별 변수에 담음
// let obj = {
//     name: '홍길동',
//     age:20,
//     address: {
//         zipcode: '123-456',
//         city: '서울'
//     }
// }

// let {name, age, address} = obj;
// let {address:{zipcode, city}} = obj
// console.log(name);

//////////////////////////////////////////////////////////////////////////////////////

// 5
// 배열 기존 요소를 삭제하거나 교체하기에 적합한 메소드
// splice()
// Array.splice(start position, delete count, item1, item2,...)
const months = ['1월', '2월', '4월', '5월', '8월']
// 추가
// months.splice(2,0,'3월')
// console.log(months);
// 변경
// months.splice(3,1,'7월')
// console.log(months);
// 삭제
let a = months.splice(3,1)
console.log(months);
console.log(a);             // array