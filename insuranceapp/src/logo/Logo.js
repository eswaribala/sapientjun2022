import React from "react";
import logoPath from '../assets/logo.jpg'
import './Logo.css'
export const Logo=()=> {
    return (
        <div>
          <img src={logoPath} className="img-style"/>
        </div>
    )
}
