package com.example.ecommerce_system.repository;

import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository

public class ProductRepository implements IProductRepository{
    public List<Product> productList;

    public ProductRepository() { productList = new LinkedList<>(); }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product getAProduct(int productId) throws ProductNotFoundException{
        for(Product product : productList) {
            if(product.getProductId() == productId) {
                return product;
            }
        }
        throw new ProductNotFoundException("Product Not Found");
    }

    @Override
    public void createAProduct(Product product) {
        productList.add(product);
    }

    @Override
    public Product updateAProduct(int productId, String name, String description, int quantity) throws ProductNotFoundException{
        for(Product product : productList) {
            if(product.getProductId() == productId) {
                product.setName(name);
                product.setDescription(description);
                product.setQuantity(quantity);
                return product;
            }
        }
        throw new ProductNotFoundException("Product Not Found");
    }
}
