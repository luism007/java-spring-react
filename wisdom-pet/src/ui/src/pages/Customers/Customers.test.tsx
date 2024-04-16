import React from "react"
import { render, screen } from "@testing-library/react"
import { Customers } from "./Customers"

describe('Customer page tests', () => {
    test('should render `Customers` heading', async () => {
        render( <Customers/>);
        const element = screen.getByTestId('customer-heading').innerHTML;
        expect(element).toEqual("Customers");
    });

    test('should render Table Wrapper div', async () => {
        render(<Customers/>);
        await screen.findByTestId('table-wrapper');
    });

})