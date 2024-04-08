describe('Test Customers Page', () => {
    beforeEach(() => {
        cy.visit('/customers');
    });

    it('displays Customers page heading', () => {
        cy.get('[data-cy="customer-heading"]')
        .contains('Customers');
    });

    it('displays a table of Customers', () => {
        cy.get('.values-wrapper').then(element => {
            cy.get('[data-testid="test-grid"]')
            .should('exist');
        });
    });
})