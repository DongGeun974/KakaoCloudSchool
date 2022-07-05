const person ={
    age:20
};

// person.name = "홍길동"
Object.defineProperty(person, "name", {
    value: "홍길동",
    writable: false,
    enumerable: true,
    configurable: true
})

console.log(person);
console.log(Object.getOwnPropertyDescriptor(person, 'name'));

person.name = '아이유';
console.log(person);

console.log(Object.keys(person));

// key
for(let key in person){
    console.log(person[key]);
}

for(let value of person){
    console.log(value);
}