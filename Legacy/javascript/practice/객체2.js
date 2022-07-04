let person =
{
    name : "hong", age : 24, phone : "010-1111-2222",
    display : function(){
        console.log(this.name, this.age, this.phone);
    },

    // display2 : ()=>{
    //     console.log(this.name, this.age, this.phone);
    // }

    setValue:function(name="", age=10, phone="")
    {
        this.name = name;
        this.age= age;
        this.phone = phone;
    }
}

person.display();
person.setValue("lim", 22, "010-2222-2222")
person.display();

console.log(person)