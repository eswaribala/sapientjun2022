import { render, screen } from '@testing-library/react';
import App from './App';
import { shallow,mount } from 'enzyme';
import logoPath from './assets/logo.jpg'
import {Logo} from './logo/Logo';

/*
test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
*/

describe('Screen should have text as John Deere Inventory App',()=>{
    it('Shallow component should have snapshots',()=>{
        const component=shallow(<App/>)
        expect(component).toMatchInlineSnapshot
    })
    it('Render Component to test Screen Text',()=>{
        render(<App/>)
        const text=screen.getByText('John Deere Inventory App')
        expect(text).toBeInTheDocument
    })
})

describe('Screen should have Button',()=> {
    it('Shallow component should have atleast one button', () => {
         const wrapper= mount(<App/>)
         const menuElement= wrapper.find('Menu')
        expect(menuElement).toHaveLength(1)
    })
})

describe("<Logo />", () => {
    it("renders an image", () => {
        const logo = shallow(<Logo />);

        expect(logo.find("img").prop("src")).toEqual(logoPath);

    });
});
