package com.example.ecommerce_system.service;

import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.model.dto.CreateProductRequestDto;
import com.example.ecommerce_system.model.dto.UpdateProductRequestDto;
import com.example.ecommerce_system.model.entity.Product;
import com.example.ecommerce_system.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class ProductService {
    private final IProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product createAProduct(final CreateProductRequestDto createProductRequestDto) throws ProductNotFoundException {
        final Product product = new Product(createProductRequestDto.getName(), createProductRequestDto.getDescription(),
                createProductRequestDto.getQuantity());
        productRepository.createAProduct(product);
        return product;
    }

    public Product updateAProduct(int productId, final UpdateProductRequestDto updateProductRequestDto) throws ProductNotFoundException{
        return productRepository.updateAProduct(productId, updateProductRequestDto.getName(), updateProductRequestDto.getDescription(),
                updateProductRequestDto.getQuantity());
    }
}
