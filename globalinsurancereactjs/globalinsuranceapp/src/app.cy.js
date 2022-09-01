import * as React from 'react';
import { mount } from '@cypress/react';
import { App } from './Sample';

describe('Sample', () => {
    it('opens the menu', () => {
        // Assume Sample contains a button "Open menu" which opens a menu
        mount(<App />);
        // Wait for the component to render (.contains() will retry until a matching element is found)
        // and click the button
        cy.contains('Open menu').click();
        // Verify that the menu opened (will retry until it succeeds or times out)
        cy.contains('Good option').should('exist');
    });
});
