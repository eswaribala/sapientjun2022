import { render, screen } from '@testing-library/react';
import MenuBar from './menu'
import {Routes} from "react-router";

test('renders learn react link', () => {
    render(<MenuBar />);
    screen.debug();
    screen.findByRole(Routes).toBeInTheDocument();

});
