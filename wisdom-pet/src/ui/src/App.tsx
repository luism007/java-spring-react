import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import {Customers} from './pages/Customers/Customers';
import {Layout} from './pages/Layout';
import Products from './pages/Products';
import { Tabs, Tab } from '@mui/material';
import { NavigationBar } from "./components/NavBar/NavigationBar";
import React from 'react';
import { Home } from './pages/Home';
export const App = () => {
  return (
    <div className="App">
     <NavigationBar/>
     <div className='appBody'>
      <Routes>
        <Route path = {'/'} element = {<Layout/>}/>
        <Route index element = {<Home/>}></Route>
        <Route path={'/customers'} element = {<Customers/>} />
        <Route path = {'/products'} element = {<Products/>} />
      </Routes>
     </div>
    </div>
  );
}
