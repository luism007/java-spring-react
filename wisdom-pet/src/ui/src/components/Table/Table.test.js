
import {render, within, screen, getByRole} from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import { Table } from './Table';

describe('Test Table Component', () => {
    let fakeProps;
    
    beforeEach(() => {
        fakeProps = {
            rows: [
              {
                id: 1,
                firstName: "Cally",
                lastName: "Reynolds",
                emailAddress: "penatibus.et@lectusa.com",
                phoneNumber: "(901) 166-8355",
                address: "556 Lakewood Park, Bismarck, ND 58505",
              },
              {
                id: 2,
                firstName: "Sydney",
                lastName: "Bartlett",
                emailAddress: "nibh@ultricesposuere.edu",
                phoneNumber: "(982) 231-7357",
                address: "4829 Badeau Parkway, Chattanooga, TN 37405",
              },
              {
                id: 3,
                firstName: "Hunter",
                lastName: "Newton",
                emailAddress: "quam.quis.diam@facilisisfacilisis.org",
                phoneNumber: "(831) 996-1240",
                address: "2 Rockefeller Avenue, Waco, TX 76796",
              },
              {
                id: 4,
                firstName: "Brooke",
                lastName: "Perkins",
                emailAddress: "sit@vitaealiquetnec.net",
                phoneNumber: "(340) 732-9367",
                address: "87 Brentwood Park, Dallas, TX 75358",
              }
            ],
            columns: [
              {
                  field: "customerId",
                  headerName: "ID",
                  width: 70
              },
              {
                  field: "firstName",
                  headerName: "First Name",
                  width: 130
              },
              {
                  field: "lastName",
                  headerName: "Last Name",
                  width: 130
              },
              {
                  field: "emailAddress",
                  headerName: "Email",
                  width: 130
              },
              {
                  field: "phoneNumber",
                  headerName: "Phone #",
                  width: 130
              },
              {
                  field: "address",
                  headerName: "Address",
                  width: 130
              }
            ]
          };
    });
    
    test("Displays correct number of rows and columns", async () => {

        render(
            <Table rows={fakeProps.rows} columns={fakeProps.columns}></Table>
        );
    
        const table = screen.getByRole('grid');
        const columns = within(table).getAllByRole('columnheader');
        const rows = within(table).getAllByRole('row');
        expect(columns).toHaveLength(6);
        expect(rows).toHaveLength(5);
    });
})