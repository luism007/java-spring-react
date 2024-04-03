package com.luisgm.wisdompet.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luisgm.wisdompet.data.entities.ProductEntity;
import com.luisgm.wisdompet.data.repositories.ProductRepository;
import com.luisgm.wisdompet.web.errors.NotFoundException;
import com.luisgm.wisdompet.web.models.Product;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductEntity translateWebToDb(Product product) {
        ProductEntity entity = new ProductEntity();

        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setVendorId(product.getVendorId());

        return entity;
    }

    private Product translateDbToWeb(ProductEntity entity) {
        
        return new Product(
            entity.getId(),
            entity.getName(),
            entity.getPrice(),
            entity.getVendorId()
        );
    } 

    public List<Product> getAllProducts() {
        Iterable<ProductEntity> productEntities = this.productRepository.findAll();
        List<Product> products = new ArrayList<>();

        productEntities.forEach(entity -> {
            products.add(this.translateDbToWeb(entity));
        });

        return products;
    } 

    public Product getProduct(long id) { 
        Optional<ProductEntity> entity = this.productRepository.findById(id);
        if(entity.isEmpty()) { 
            throw new NotFoundException("No product found with corresponding ID");
        }
        return this.translateDbToWeb(entity.get());
    }

    public Product createOrUpdate(Product product) { 
        ProductEntity entity = this.translateWebToDb(product);
        entity = this.productRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }

}
