import './App.css';
import {Component} from "react";
import Logo from './Logo/logo'
import Banner from './Banner/banner';
import MenuBar from './Menu/menu';

//stateful component
export class App extends Component{

    constructor(props, context) {
        super(props, context);
        console.log("Component Constructor.....")
    }

    render() {
        console.log("Rendering.....")
        return(
            <section>
            <header className="header">
            <Logo></Logo>
            <h1 className="multicolortext">Global Insurance</h1>
            <Banner></Banner>
            </header>
                <article>
                    <MenuBar></MenuBar>
                </article>
            </section>
        )
    }

    componentDidMount() {
        console.log("Component Mounted....");

    }

    componentWillMount() {
        console.log("Component Will Mount....");
    }
}


