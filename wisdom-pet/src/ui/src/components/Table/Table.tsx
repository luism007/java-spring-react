import React from "react";
import { DataGrid, GridColDef } from '@mui/x-data-grid';

type TableProps = {
    columns: any[],
    rows: any[],

}
export const Table = (props: TableProps) => {
    return(
        <DataGrid data-testid = "test-grid"
            rows={props.rows}
            columns={props.columns}
            >
        </DataGrid>
    )
}
