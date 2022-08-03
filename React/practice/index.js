
// Array.prototype.map()
// const array1 = [1,4,9,16]
// const map1 = array1.map(function(x){
//     return x*2
// })
// const map1 = array1.map((x)=>x*2)
// console.log(map1)



const words = ['세종대왕', '이황', '강감찬', '샤인머스켓', '소리없는 아우성']
// 글자 길이가 3자를 초과하는 데이터만 추려서 새로운 배열 생성
const result = words.filter((word) => {
    return word.length > 3;
})
console.log(result);