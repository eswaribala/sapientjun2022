//globalscope
var country='India';


//object

var bank=new Object;
bank.bankId=39569;
bank.bankName='SBI';
console.log(bank);

//constructor using fn
function Currency(code,name,value){
    this.code=code;
    this.name=name;
    this.value=value;
    //privileged member
    var data=this.code+","+this.name;
    //privileged method
    this.showData=function(){
        console.log(data);
    }
}
//method creation
Currency.prototype.update=function(newValue){
    this.value=newValue;
    //privileged member not accessible
    //console.log(data);
    //console.log(value);
}
currency=new Currency('INR','Rupees',80);
console.log(currency);
//invoke method
currency.update(72)
console.log(currency);

//access privileged method
currency.showData();

var country={
    "countryId":91,
    "name":"India"
}

console.log(country);


//abstract
function Person(adharCardNo,firstName,lastName){
    this.adharCardNo=adharCardNo;
    this.firstName=firstName;
    this.lastName=lastName;
   if(this.constructor === Person){
        throw new Error('Person is abstract class, instance cannot be created');
    }
}

Person.prototype.setAdharCardNo=function(adharCardNo){
    this.adharCardNo=adharCardNo;
}

//function Customer(adharCardNo,firstName,lastName,customerId, userName, password){
    //super()
    //Person.call(this,adharCardNo,firstName,lastName);
function Customer(customerId, userName, password){
    this.customerId=customerId;
    this.userName=userName;
    this.password=password;
}
//inheritance
//Customer.prototype=new Person();

//inheritance for the abstract class
Customer.prototype=Object.create(Person.prototype);


//var person=new Person("A324865846","parameswari",
 //   "bala");
//var customer=new Customer("A324865846","parameswari",
//    "bala","2745325","user1","test@123");

customer=new Customer("2745325","user1","test@123");
customer.setAdharCardNo("A2875874");
console.log(customer.adharCardNo);

//typeof
console.log(typeof customer);

//immediate invocation of function
//function expression
var setCountry=function (countryName) {
    //local scope
    var country = countryName;
    console.log(country);
//}('USA');
}

setCountry('Singapore');

//global scope
console.log(country);
