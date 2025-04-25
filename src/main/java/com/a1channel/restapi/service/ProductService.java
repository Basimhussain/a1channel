package com.a1channel.restapi.service;

import com.a1channel.restapi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    
    List<Product> getAllProducts();
    
    Optional<Product> getProductById(Long id);
    
    Product saveProduct(Product product);
    
    Product updateProduct(Long id, Product productDetails);
    
    void deleteProduct(Long id);
    
    List<Product> getProductsByCategory(String category);
    
    List<Product> searchProductsByName(String name);
    
    List<Product> getProductsWithPriceLessThan(double price);
} 