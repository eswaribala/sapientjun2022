import logo from './logo.svg';
import './App.css';
import {Component} from "react";
//stateful component
export class App extends Component{

    constructor(props, context) {
        super(props, context);
        console.log("Component Constructor.....")
    }

    render() {
        console.log("Rendering.....")
        return(
            <div className="header">
            <h1 className="multicolortext">Global Insurance</h1>
            </div>
        )
    }

    componentDidMount() {
        console.log("Component Mounted....");

    }

    componentWillMount() {
        console.log("Component Will Mount....");
    }
}


