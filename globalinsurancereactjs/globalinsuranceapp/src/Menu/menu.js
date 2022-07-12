import { Menubar } from 'primereact/menubar';
import {items} from "../Models/menudata";
import React from 'react'
import './menu.css'
const menuBar=()=>(
    <div className="menu">
    <Menubar model={items}/>
    </div>
)

export default menuBar

