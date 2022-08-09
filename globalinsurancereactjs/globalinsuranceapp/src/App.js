import './App.css';
import {Component} from "react";
import Logo from './Logo/logo'
import Banner from './Banner/banner';
import MenuBar from './Menu/menu';
import { Provider } from 'react-redux'
import store from './redux/store'
import { Dialog } from 'primereact/dialog';
import { Button } from 'primereact/button';
//stateful component
export class App extends Component{

    constructor(props, context) {
        super(props, context);
      //  console.log("Component Constructor.....");
        //create state
        this.state={
            currentTime:new Date(),
            displayBasic: false,

            position: 'center'
        }

        this.onClick = this.onClick.bind(this);
        this.onHide = this.onHide.bind(this);
    }

    timerEvent=()=>{
        //updating the state
        this.setState({
            currentTime:new Date()
        })


    }
    onClick(name, position) {
        let state = {
            [`${name}`]: true
        };

        if (position) {
            state = {
                ...state,
                position
            }
        }

        this.setState(state);
    }

    onHide(name) {
        this.setState({
            [`${name}`]: false
        });
    }

    renderFooter(name) {
        return (
            <div>
                <Button label="No" icon="pi pi-times" onClick={() => this.onHide(name)} className="p-button-text" />
                <Button label="Yes" icon="pi pi-check" onClick={() => this.onHide(name)} autoFocus />
            </div>
        );
    }



    render() {
       // console.log("Rendering.....")
        return(
            <Provider store={store}>
            <section>
            <header className="header">
            <Logo></Logo>
            <h1 className="multicolortext">Global Insurance</h1>

            <Banner></Banner>
                <h4 className="multicolortext">{this.state.currentTime.toLocaleTimeString()}</h4>
            </header>
                <article>
                    <MenuBar></MenuBar>
                    <Button label="Show" icon="pi pi-external-link" onClick={() => this.onClick('displayBasic')} />
                    <Dialog header="Header" visible={this.state.displayBasic} style={{ width: '50vw' }} footer={this.renderFooter('displayBasic')} onHide={() => this.onHide('displayBasic')}>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                            Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                            cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </Dialog>

                </article>
            </section>
            </Provider>
        )
    }

    componentDidMount() {
        console.log("Component Mounted....");
       setInterval(this.timerEvent,1000);
    }

    componentWillMount() {
        console.log("Component Will Mount....");
    }
}


