package com.luisgm.wisdompet.web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.luisgm.wisdompet.services.ProductService;
import com.luisgm.wisdompet.web.errors.BadRequestException;
import com.luisgm.wisdompet.web.models.Product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) { 
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return this.productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) { 
        return this.productService.createOrUpdate(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) { 
        return this.productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product) { 
        if(id != product.getId()) { 
            throw new BadRequestException("ids do not match");
        }

        return this.productService.createOrUpdate(product);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteProduct(@PathVariable("id") long id, @RequestBody Product product) { 
        if(id != product.getId()) { 
            throw new BadRequestException("ids do not match");
        }
        this.productService.deleteProduct(id);
    }
    
}
