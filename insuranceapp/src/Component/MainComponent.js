import React, { Component } from 'react';
//import './main-component.css';
import ChildComponent from './ChildComponent';

export default class MainComponent extends Component {
    constructor (props) {
        super(props);
        this.label = "I’m your father";
    };

    onSubmit = (option) => (option === "I’m your father" ? 'cool' : 'not cool');

    render () {
        return(
            <div className="container">
                <ChildComponent label={this.label} onSubmit={this.onSubmit} />
            </div>
        );
    };
};
