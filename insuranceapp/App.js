import logo from './logo.svg';
import './App.css';
import React from "react";
import {Menu} from './menu/Menu'
import {Logo} from './logo/Logo'
import productPath from './assets/product.jpg'
/*
function App() {
  return (
    <div className="App">
     <h2>John Deere Inventory App</h2>
    </div>
  );
}
*/
export class App extends React.Component{

    constructor(props, context) {
        super(props, context);
        console.log("component instantiated...")
        //create state
        this.state={
            currentTime:new Date(),
            menu:[{
                menuId:1,
                name:'Home',
                path:'#/Home'
            },
                {
                    menuId:2,
                    name:'Add Product',
                    path:'#/AddProduct'
                },
                {
                    menuId:3,
                    name:'View Product',
                    path:'#/ViewProduct'
                }



            ]

        }
    }



    componentDidMount() {
       //console.log("Component mounted....")
        setInterval(()=>(this.tick(),1000))
    }

    //updating the state
    tick(){
        this.setState({
            currentTime:new Date()
        })
    }

    render() {
       // console.log("Component rendered....")
        return (
            <div className='App'>

                <div className='header-style'>
                <Logo/>
                <h2>John Deere Inventory App</h2>
                    <h4>{this.state.currentTime.toLocaleTimeString()}</h4>
                <img src={productPath} className="img"/>
                </div>

                <div className='menu-style'>
                <Menu items={this.state.menu} />
                </div>
            </div>
        );
    }
}

export default App;
