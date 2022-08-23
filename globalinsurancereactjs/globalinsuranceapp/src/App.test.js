import {fireEvent, queryByAttribute, render, screen, waitFor} from '@testing-library/react';
import {App} from './App';

test('renders learn react link', () => {
  render(<App />);
  screen.debug();
  
  const linkElement = screen.getByText(/Global Insurance/i);
  expect(linkElement).toBeInTheDocument();
});
describe("<App />", () => {



  test('Show Dialog', async() => {
    const dom=render(<App />);
    const getById = queryByAttribute.bind(null, 'id');
    const btnClick =  getById(dom.container, 'dialog-btn');
    fireEvent.click(btnClick);
    await waitFor(() => getById(dom.container, 'app-dialog'));

  });



});
