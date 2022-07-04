let person = {"name" : "hong", "age" : 12, "phone" : "010-0000-1111"};

console.log(Object.entries(person))
for(const[key, value] of Object.entries(person)){
    console.log(`${key} ===> ${value}`)
}

let students = [
    {"name" : "Hond", "kor" : 90, "eng" : 80, "mat" : 20},
    {"name" : "Dond", "kor" : 100, "eng" : 80, "mat" : 10},
    {"name" : "Kond", "kor" : 50, "eng" : 20, "mat" : 30},
    {"name" : "Bond", "kor" : 10, "eng" : 100, "mat" : 70},    
]

console.log("객체 수" , students.length)
console.log(students[0].name)
console.log(students[0]["name"])
console.log(students[0]["kor"])

// 추가하기
students.push({"name" : "kukk", "kor" : 10, "eng" : 100, "mat" : 70},)

for(i in students)
{
    console.log(students[i].name, students[i]["kor"], students[i]["eng"])
}

for (item of students)
{
    console.log(item.name, item.age, item.eng, item.mat)
}


let myProduct = {
    "product_name" : "노트북",
    "product_info" : [
        {company:"회사1", model:"modelAAA", price: 20000000},
        {company:"회사2", model:"modelBBB", price: 1000000},
        {company:"회사3", model:"modelCCC", price: 400000000},
    ]
}

console.log(myProduct.product_name)
for (item of myProduct.product_info)
{
    console.log(item.company, item.model, item.price)
}

let s = JSON.stringify(person)
console.log(s)
let person2 = JSON.parse(s)
console.log(person2)

s= JSON.stringify(myProduct)
console.log(s)
person2 = JSON.parse(s)
console.log(person2)