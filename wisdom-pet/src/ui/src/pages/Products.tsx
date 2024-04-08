import React, { useEffect, useState } from "react";
import { Product } from "../types/Products";
import { GridColDef } from "@mui/x-data-grid";
import { Table } from "../components/Table/Table";

const Products = () => {
    
    const [products, setProducts] = useState<Product[]>([]);
    
    const columns: GridColDef[] = [
      {
        field: "id",
        headerName: "ID",
        minWidth: 70
      },
      {
        field: "name",
        headerName: "Product Name",
        minWidth: 300
      },
      {
        field: "price",
        headerName: "Price",
        minWidth: 300
      },
      {
        field: "vendorId",
        headerName: "Vendor ID",
        minWidth: 300
      }
    ];

    const getProducts = async() => {
        const res = await fetch('/api/products');
        const products = await res.json();
        setProducts(products);
    }

    useEffect(() => {
        getProducts().catch(e => console.log('error fetching products', e));
    }, [])
    
    return (
      <>
        <h1> Products </h1>
        { products?.length > 0 &&
          <Table columns = {columns} rows = {products}></Table>
        }
      </>
    );
}

export default Products;