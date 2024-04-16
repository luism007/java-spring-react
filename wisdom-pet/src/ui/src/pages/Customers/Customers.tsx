import React, { useEffect, useState } from "react";
import { Table } from "../../components/Table/Table";
import { GridColDef } from "@mui/x-data-grid";
import { Customer } from "../../types/Customer";
import './Customers.css';
import { Skeleton } from "@mui/material";
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

    const transformToTableData = (c: Customer) => {
        return {
            ...c,
            id: c.customerId
        }
    };

    const getCustomers = async () => {
        const res = await fetch('/api/customers');
        const customers = await res.json();
        setCustomers(customers.map((c: Customer) => transformToTableData(c)));
    }

    useEffect(() => {
        getCustomers().catch(e => {
            console.log('error fetching customers', e);
        });
    }, []);

    return (
        <>
            <h1 data-cy="customer-heading" data-testid="customer-heading">Customers</h1>
            <div className="values-wrapper" data-testid="table-wrapper">
                {(customers?.length > 0 ) ? <Table data-cy="customers-table" columns={columns} rows={customers}>
                </Table > : <Skeleton variant = "rounded" width={"100%"} height={"100%"}/>}
            </div>
        </>
    );
};