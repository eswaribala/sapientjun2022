/**
 * Created by BALASUBRAMANIAM on 29-03-2017.
 */

//patterns and flag

let str = "NIIT Technologies Greater Noida!";

let regexp = /Greater/;
console.log( str.search(regexp) ); //prints position

str = "NIIT Technologies Greater Noida!";

console.log( str.search(/technologies/) ); // -1 (not found)
console.log( str.search(/technologies/i) ); // 2


//methods

str = "A drop of ink may make a million think";

console.log( str.search( /a/i ) ); // 0 (the first position)

str = "Fame is the thirst of youth";

let result = str.match( /fame/i );

console.log( result[0] );    // Fame (the match)
console.log( result.index ); // 0 (at the zero position)
console.log( result.input ); // "Fame is the thirst of youth" (the string)

str = "JavaScript is a programming language";

result = str.match( /JAVA(SCRIPT)/i );

console.log( result[0] ); // JavaScript (the whole match)
console.log( result[1] ); // script (the part of the match that corresponds to the parentheses)
console.log( result.index ); // 0
console.log( result.input ); // JavaScript is a programming language


str = "+7(903)-123-45-67";

reg = /\d/g;

console.log( str.match(reg) );
str = "+7(903)-123-45-67";

console.log( str.match(/\d+/g) );

reg = /[-.\w]+@([\w-]+\.)+[\w-]{2,20}/g;

console.log("my@mail.com @ his@site.com.uk".match(reg));



//substring match
var re = /(\w+)\s(\w+)/;
 str = 'John Smith';
var newstr = str.replace(re, '$2, $1');
console.log(newstr);
//search
var re = /\w+\s/g;
 str = 'NIIT Technologies Greater Noida';
var myArray = str.match(re);
console.log(myArray);

