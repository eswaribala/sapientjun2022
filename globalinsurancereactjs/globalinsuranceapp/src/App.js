import './App.css';
import {Component} from "react";
import Logo from './Logo/logo'
import Banner from './Banner/banner'

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
            <Logo></Logo>
            <h1 className="multicolortext">Global Insurance</h1>
            <Banner></Banner>
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


