import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './pages/Layout';
import Home from './pages/Home';
import {Customers} from './pages/Customers';
import Products from './pages/Products';
function App() {
  return (
    <div className="App">
     <BrowserRouter>
      <Routes>
        <Route path = {'/'} element = {<Layout/>}/>
        <Route index element = {<Home/>}></Route>
        <Route path={'/customers'} element = {<Customers/>} />
        <Route path = {'/products'} element = {<Products/>} />
      </Routes> 
    </BrowserRouter>
    </div>
  );
}

export default App;
