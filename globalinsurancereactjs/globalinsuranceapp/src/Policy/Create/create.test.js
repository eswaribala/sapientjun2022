import {act, render, renderHook, screen} from '@testing-library/react';
import Create from "./create";
import { Provider } from 'react-redux';
import mockAxios from "axios";
import configureMockStore from "redux-mock-store";

import thunk from "redux-thunk";
import promiseMiddleware from "redux-promise-middleware";
import {InputText} from "primereact/inputtext";
import {create} from "json-server";
const initialState = { output: 10 };
const mockStore = configureMockStore([thunk]);
let store;
beforeEach(() => {
    store = mockStore({
        products: {}
    });
});
test('renders learn react link', () => {
    render( <Provider store={store}>
        <Create />
    </Provider>);
    screen.debug();
    const linkElement = screen.getByText(/Add Policy/i);
    expect(linkElement).toBeInTheDocument();

});

test('should assign value', () => {
    const { result } = renderHook(() => Create())

     expect(result.current.policyNo).toBe(0)
})
