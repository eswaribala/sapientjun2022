import React from "react";
import axios from "axios";

export default class ViewProduct extends React.Component{
    getUserData() {
        axios.get('https://reqres.in/api/users/2')
            .then(response => console.log(response.data))
            .catch(error => console.log(error));
    }
    render() {
        console.log("View Product....")
        return(

                <h1>View Product</h1>

        )
    }
}



