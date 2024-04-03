import React from "react";

const Products = () => {
    const products = [{"id":1,"name":"Strong Joints Dog Supplement","price":5.87,"vendorId":9},{"id":2,"name":"Healthy Coat Dog Supplement","price":6.44,"vendorId":4}];
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