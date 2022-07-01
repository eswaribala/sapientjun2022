/*
   GDP = C + G + I + NX

C = consumption or all private consumer spending within a country’s economy, including, durable goods (items with a lifespan greater than three years), non-durable goods (food & clothing), and services.

G = total government expenditures, including salaries of government employees, road construction/repair, public schools, and military expenditure.

I = sum of a country’s investments spent on capital equipment, inventories, and housing.

NX = net exports or a country’s total exports less total imports.
    */
var country={
    "countryId":91,
    "name":"India",
    //arrow function
    computeGDP:(C,G,I,NX)=>{
       return C+G+I+NX;
    }
}
console.log(country.computeGDP(10,7,3,23));

//map function

var mobileMap =new Map();
mobileMap.set('Sanjay',7564365693);
mobileMap.set('Anitha',39257837);
mobileMap.set('Zahra',946593569);

//read the elements
for([key,value] of mobileMap.entries()){
    console.log(key,value);
}
