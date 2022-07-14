import React from 'react';
import { shallow } from 'enzyme';
import MainComponent from './MainComponent';

jest.mock('./ChildComponent'); //ChildComponent is now a mock constructor

const wrapper = shallow(<MainComponent />);
let container, containerProp, childContainer, childContainerProps;

describe("MainComponent", () => {
    beforeEach(() => {
        container = wrapper.find("div");
        containerProp = container.props();
    });

    it("should have a <div>", () => {
        expect(container).toHaveLength(1);
    });

    it("should have a <div> with properly className prop", () => {
        expect(containerProp.className).toEqual("container");
    });

    describe("ChildComponent", () => {
        beforeEach(() => {
            childContainer = wrapper.find('ChildComponent');
            childContainerProps = childContainer.props();
        });

        it("should have a <ChildContainer>", () => {
            expect(childContainer).toHaveLength(1);
        });

        it("should have label as prop", () => {
            expect(childContainerProps.label).toEqual("I’m your father");
        });

        it("should have onSubmit as prop", () => {
            expect(typeof childContainerProps.onSubmit).toBe("function");
        });
    });
});
