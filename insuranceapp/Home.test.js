import React from 'react';
import Home from './Home';
import { shallow,mount } from 'enzyme';
import {doMerge} from "./Home";

test("returns undefined by default", () => {
    const mock = jest.fn();

    let result = mock("handleSubmit");

    expect(result).toBeUndefined();
    expect(mock).toHaveBeenCalled();
    expect(mock).toHaveBeenCalledTimes(1);
    expect(mock).toHaveBeenCalledWith("handleSubmit");
});

test("mock implementation", () => {
    const mock = jest.fn(() => "Data Received");

    expect(mock("handleSubmit")).toBe("Data Received");
    expect(mock).toHaveBeenCalledWith("handleSubmit");
});

test("also mock implementation", () => {
    const mock = jest.fn().mockImplementation(() => "Data Received");

    expect(mock("handleSubmit")).toBe("Data Received");
    expect(mock).toHaveBeenCalledWith("handleSubmit");
});

test("mock implementation one time", () => {
    const mock = jest.fn().mockImplementationOnce(() => "Data Received");

    expect(mock("handleSubmit")).toBe("Data Received");
    expect(mock).toHaveBeenCalledWith("handleSubmit");

    expect(mock("Data Received With Date and Time")).toBe(undefined);
    expect(mock).toHaveBeenCalledWith("Data Received With Date and Time");
});

test("mock return value", () => {
    const mock = jest.fn();
    mock.mockReturnValue("Data Received");

    expect(mock("handleSubmit")).toBe("Data Received");
    expect(mock).toHaveBeenCalledWith("handleSubmit");
});

test("mock promise resolution", () => {
    const mock = jest.fn();
    mock.mockResolvedValue("Data Received");

    expect(mock("handleSubmit")).resolves.toBe("Data Received");
    expect(mock).toHaveBeenCalledWith("handleSubmit");
});

//dependency injection

test("calls callback with arguments merge", () => {
    const mockCallback = jest.fn();
     doMerge('Parameswari', 'Bala', mockCallback);
    expect(mockCallback).toHaveBeenCalledWith('ParameswariBala');
});

/*//Spy or mock a function with jest.spyOn
test("calls mergeName", () => {
    const addMock = jest.spyOn(doMerge);

    // calls the original implementation
    expect(doMerge('Parameswari', 'Bala')).toEqual('ParameswariBala');

    // and the spy stores the calls to add
    expect(addMock).toHaveBeenCalledWith('Parameswari', 'Bala');
});*/
describe('HomeComponent', () => {
    test('should handle click correctly', () => {
        const logSpy = jest.spyOn(console, 'log');
        const wrapper = shallow(<Home />);
        const button = wrapper.find('button');
        expect(button.text()).toBe('Click Me');
        button.simulate('click');
        expect(logSpy).toBeCalledWith('Home Instance');
    });
});
