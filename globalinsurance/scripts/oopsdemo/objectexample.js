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

