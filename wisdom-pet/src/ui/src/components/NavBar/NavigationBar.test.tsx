import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import React from "react";
import { MemoryRouter} from "react-router-dom";
import { NavigationBar } from "./NavigationBar";
import { App } from "../../App";
import { act } from "react-dom/test-utils";


describe('Navigation Bar tests', () => {

    test('should navigate to Customers page when Customers tab clicked', async () => {

        render(
            <MemoryRouter initialEntries={['/']}>
                <NavigationBar/>
            </MemoryRouter>
        );

        act(() => {
            const link = screen.getByRole('link', {name: /customers/i});
            userEvent.click(link);
        });

        await screen.findByText('Customers');
    });

    test('should navigate to Products page when Products tab clicked', async () => {
        render(
            <MemoryRouter>
                <NavigationBar/>
            </MemoryRouter>
        );

        act(() => {
            const link = screen.getByRole('link', {name: /products/i});
            userEvent.click(link);
        })
        await screen.findByText('Products');
    });

    test('should navigate to Home page when Home tab is clicked', async () => {
        render(
            <MemoryRouter>
                <App/>
            </MemoryRouter>
        );

        act(() => {
            const link = screen.getByRole('link', {name: /home/i });
            userEvent.click(link);
        })
        await screen.findByText('Admin');
    })
})