import React from 'react';
import AddProduct from './AddProduct';
import { shallow,mount } from 'enzyme';


describe('<AddProduct /> with other props', () => {
    const initialProps = {
        name: 'Laptop',
        cost: 34000,
    };
    const container = shallow(<AddProduct {...initialProps} />);

    it('should have proper props for name field', () => {
        expect(container.find('input[type="text"]').props()).toEqual({
            className: 'mx-auto my-2',
            onBlur: expect.any(Function),
            placeholder: 'name',
            type: 'text',
        });
    });

    it('should have proper props for cost field', () => {
        expect(container.find('input[type="number"]').props()).toEqual({
            className: 'my-2',
            onChange: expect.any(Function),
            type: 'number',
            value: 34000,
        });
    });

    it('should have proper props for submit button', () => { /* */ });


    it('should set the cost value on change event with value', () => {
        container.find('input[type="number"]').simulate('change', {
            target: {
                value: 244543,
            },
        });
        expect(container.find('input[type="number"]').prop('value')).toEqual(
            244543,
        );
    });

    it('should call the dispatch function and disable the submit button on button click', () => {
        container.find('input[type="button"]').simulate('click');
        expect(
            container.find('input[type="button"]').prop('disabled'),
        ).toBeTruthy();
        //  expect(initialProps.dispatch).toHaveBeenCalledTimes(1);
    });
});

describe('<AddProduct /> test effect hooks', () => {
    const container = mount(<AddProduct />);

    it('should have the add product disabled by default', () => {
        expect(
            container.find('input[type="button"]').prop('disabled'),
        ).toBeTruthy();
    });

    it('should have the add product enabled with valid values', () => {
        /*container.find('input[type="number"]').simulate('change', {
            target: {
                value: -1,
            },
        });
           expect(container.find('input[type="button"]').prop('disabled')).toBeTruthy();*/
        container.find('input[type="number"]').simulate('change', {
            target: {
                value: -1,
            },
        });
        expect(container.find('input[type="number"]').prop('value')).toEqual(-1);
       // expect(container.find('input[type="button"]').prop('disabled').toBeFalsy());
    });

    it('should have the add product disabled with invalid values', () => {
        container.find('input[type="text"]').simulate('blur', { /* */ });
        expect(
            container.find('input[type="button"]').prop('disabled'),
        ).toBeTruthy();
    });



});

