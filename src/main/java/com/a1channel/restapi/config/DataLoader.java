package com.a1channel.restapi.config;

import com.a1channel.restapi.model.Product;
import com.a1channel.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        // Clear existing data
        productRepository.deleteAll();

        // Create sample products
        Product product1 = new Product();
        product1.setName("Laptop Pro");
        product1.setDescription("High-performance laptop with 16GB RAM and 512GB SSD");
        product1.setPrice(new BigDecimal("1299.99"));
        product1.setStockQuantity(50);
        product1.setCategory("Electronics");
        product1.setImageUrl("https://example.com/laptop.jpg");

        Product product2 = new Product();
        product2.setName("Smartphone X");
        product2.setDescription("Latest smartphone with 6.5 inch display and 128GB storage");
        product2.setPrice(new BigDecimal("799.99"));
        product2.setStockQuantity(100);
        product2.setCategory("Electronics");
        product2.setImageUrl("https://example.com/smartphone.jpg");

        Product product3 = new Product();
        product3.setName("Coffee Maker");
        product3.setDescription("Programmable coffee maker with thermal carafe");
        product3.setPrice(new BigDecimal("89.99"));
        product3.setStockQuantity(30);
        product3.setCategory("Kitchen Appliances");
        product3.setImageUrl("https://example.com/coffeemaker.jpg");

        Product product4 = new Product();
        product4.setName("Running Shoes");
        product4.setDescription("Lightweight running shoes with breathable mesh");
        product4.setPrice(new BigDecimal("129.99"));
        product4.setStockQuantity(75);
        product4.setCategory("Sports");
        product4.setImageUrl("https://example.com/shoes.jpg");

        // Save all products
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));

        System.out.println("Sample data loaded!");
    }
} 