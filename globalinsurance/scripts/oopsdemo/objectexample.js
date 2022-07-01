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
}

currency=new Currency('INR','Rupees',80);
console.log(currency);

var country={
    "countryId":91,
    "name":"India"
}

console.log(country);

