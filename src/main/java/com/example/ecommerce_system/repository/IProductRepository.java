package com.example.ecommerce_system.repository;

import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.model.entity.Product;
import com.example.ecommerce_system.model.entity.User;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProducts();
    Product getAProduct(int productId) throws ProductNotFoundException;
    void createAProduct(Product product);
    Product updateAProduct(int productId, String name, String description, int quantity) throws ProductNotFoundException;
}

