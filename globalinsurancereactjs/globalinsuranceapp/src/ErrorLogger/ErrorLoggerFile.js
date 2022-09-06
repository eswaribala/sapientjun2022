import React, { Component } from 'react';
import { ErrorHandler} from 'universal-react-logger';

class Homepage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            counter: 0,
            error: this.props.error,
            errorInfo: this.props.errorInfo
        };
        this.handleClick = this.handleClick.bind(this);
        this.makeError = this.makeError.bind(this);
    }

    handleClick() {
        this.setState(({counter}) => ({
            counter: counter + 1
        }));
    }

    makeError () {
        try{
            // pretend to call a function that does not exist
            this.functionThatDontExist();
        } catch(error) {
            // send the error using the setEventError function
            this.props.setEventError(error);
        }
    };

    render() {
        if (this.state.counter === 5) {
            // Simulate a render error
            throw new Error('Error on render');
        }

        return (
            <div>
                <h1 key="welcome">universal-react-logger</h1>
                <button onClick={this.handleClick}>Update counter: {this.state.counter}</button>
                <button onClick={() => {this.makeError()}}>Make event error</button>
            </div>
        );
    }
}

export default ErrorHandler(Homepage, true);
