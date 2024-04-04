import React, { useEffect, useState } from "react";
import { Table } from "../components/Table/Table";
import { GridColDef } from "@mui/x-data-grid";
import { Customer } from "../types/Customer";

export const Customers = () => {

    const [customers, setCustomers] = useState<Customer[]>([]);
    const columns: GridColDef[] = [
        {
            field: "id",
            headerName: "ID",
            minWidth: 70

        },
        {
            field: "firstName",
            headerName: "First Name",
            minWidth: 150
        },
        {
            field: "lastName",
            headerName: "Last Name",
            minWidth: 150
        },
        {
            field: "emailAddress",
            headerName: "Email",
            minWidth: 300
        },
        {
            field: "phoneNumber",
            headerName: "Phone #",
            minWidth: 300
        },
        {
            field: "address",
            headerName: "Address",
            minWidth: 400
        }
    ]
    const getCustomers = async () => {
        const res = await fetch('/api/customers');
        const customers = await res.json();
        setCustomers(customers.map((c: Customer) => {
            return {
                id: c.customerId, 
                firstName: c.firstName,
                lastName: c.lastName,
                emailAddress: c.emailAddress,
                phoneNumber: c.phoneNumber,
                address: c.address
            } 
        }));
    }
    useEffect(() => {
        getCustomers().catch(e => {
            console.log('error fetching customers', e);
        });
    }, []);

    return (
        <>
            <h1>Customers</h1>
            {customers?.length > 0 && <Table columns={columns} rows={customers}>
            </Table >}
        </>
    );
};