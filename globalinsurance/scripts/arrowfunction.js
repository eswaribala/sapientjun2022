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
console.log(mobileMap.keys());
console.log(mobileMap.values());


users=[
    {
        "id": 1,
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": {
            "street": "Kulas Light",
            "suite": "Apt. 556",
            "city": "Gwenborough",
            "zipcode": "92998-3874",
            "geo": {
                "lat": "-37.3159",
                "lng": "81.1496"
            }
        },
        "phone": "1-770-736-8031 x56442",
        "website": "hildegard.org",
        "company": {
            "name": "Romaguera-Crona",
            "catchPhrase": "Multi-layered client-server neural-net",
            "bs": "harness real-time e-markets"
        }
    },
    {
        "id": 2,
        "name": "Ervin Howell",
        "username": "Antonette",
        "email": "Shanna@melissa.tv",
        "address": {
            "street": "Victor Plains",
            "suite": "Suite 879",
            "city": "Wisokyburgh",
            "zipcode": "90566-7771",
            "geo": {
                "lat": "-43.9509",
                "lng": "-34.4618"
            }
        },
        "phone": "010-692-6593 x09125",
        "website": "anastasia.net",
        "company": {
            "name": "Deckow-Crist",
            "catchPhrase": "Proactive didactic contingency",
            "bs": "synergize scalable supply-chains"
        }
    }]

var userMap= new Map(Object.entries(users));
for([key,value] of userMap.entries()){
  console.log(key,value);

  }

//set
//union operation
var loanSet = new Set([347,346,5387]);
var fixedSet = new Set([347,4543,54654,435435]);
var result = new Set([...loanSet, ...fixedSet]);
console.log(result);
//intersection
var interResult = new Set(
    [...loanSet].filter(x => fixedSet.has(x)));
console.log(interResult);

var dotnetTrainees=new Set(["Shyam","Ram","Sangeeta"]);
var javaTrainees=new Set(["Shyam","Sunita","Jansy"]);
var interResult = new Set(
    [...dotnetTrainees].filter(x => javaTrainees.has(x)));
console.log(interResult);
//to count the elements
console.log(dotnetTrainees.size);

//difference

var difference1 = new Set(
    [...dotnetTrainees].filter(x => !javaTrainees.has(x)));

var difference2 = new Set(
    [...javaTrainees].filter(x => !dotnetTrainees.has(x)));

var result = new Set([...difference1, ...difference2]);
console.log(result);
