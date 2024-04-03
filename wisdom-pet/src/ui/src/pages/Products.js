import React, { useEffect, useState } from "react";

const Products = () => {
    
    const [products, setProducts] = useState([]);
    
    const getProducts = async() => {
        const res = await fetch('/api/products');
        const products = await res.json();
        setProducts(products);
    }

    useEffect(() => {
        getProducts().catch(e => console.log('error fetching products', e));
    }, [])
    
    return (
      <table>
        <thead>
          <th>ID </th>
          <th>Name</th>
          <th>Price</th>
          <th>Vendor ID </th>
        </thead>
        <tbody>
          {products.map(product => {
            const { id, name, price, vendorId } =
              product;

            return (
              <tr key={id}>
                <td> {id} </td>
                <td> {name} </td>
                <td> {price} </td>
                <td> {vendorId} </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    );
}

export default Products;