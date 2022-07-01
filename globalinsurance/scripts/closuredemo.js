function outer(){
    let customerId=3485874;
    //inner function
    return function readCustomerId(){
        console.log(customerId);
    }
    //return readCustomerId();
   //return readCustomerId;
}

//console.log(outer());
let result=outer();
result();
//closure
customer=function(){
    var customerId=3785637;
    var balance=50000;
    return {
        increment: function(){
            balance+= 25000;
        },
        getBalance:function(){
            return balance;
        }
    };
}

customer().increment();
console.log(customer().getBalance());
