import React, { Component } from 'react';
import { string, func } from 'prop-types';
//import './child-component.css';

export default class ChildComponent extends Component {
    static propTypes = {
        label: string,
        onSubmit: func.isRequired
    };

    static defaultProps = {
        label: "I\’m your son"
};

constructor (props) {
    super(props);
};

onClick = () => (onSubmit(this.props.label));

render () {
    const { onSubmit, label} = this.props;
    return(
        <div className="container">
            <button onClick={this.onClick()}>{label}</button>
        </div>
    );
};
};
