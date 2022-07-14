import React from "react";
const sampleMethod = () => {
    console.log('Home Instance');
};
export default class Home extends React.Component{
    render() {

        return(
               <div>
                <h1>Home</h1>
                   <button onClick={sampleMethod} type="button">Click Me</button>;

               </div>
        )
    }
}
export const doMerge=(firstName, lastName, callback)=>{
    callback(firstName + lastName);
};
