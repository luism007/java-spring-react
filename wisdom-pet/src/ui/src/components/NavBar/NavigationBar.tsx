import React from "react";
import { Link } from "react-router-dom";
import './NavigationBar.css';
export const NavigationBar = () => {
    return (
        <div className="navigationBar-wrapper">
            <ul style={{ listStyleType: 'none' }} className="navigationBar">
                <li><Link to = {'/'}> Home </Link></li>
                <li><Link to={'/customers'}> Customers </Link></li>
                <li><Link to={'/products'}> Products </Link></li>
            </ul>
        </div>
    );
}
