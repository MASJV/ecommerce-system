package com.example.ecommerce_system.controller;

import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.model.dto.CreateProductRequestDto;
import com.example.ecommerce_system.model.dto.UpdateProductRequestDto;
import com.example.ecommerce_system.model.entity.Product;
import com.example.ecommerce_system.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j // helps in logging
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        log.info("received a request to get all products ");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getAProduct(@PathVariable("productId") int productId) {
        log.info("received a request to product with id {} ", productId);
        try {
            Product product = productService.getAProduct(productId);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createAProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        log.info("received a request to create a product with body {} ", createProductRequestDto);
        try {
            Product product = productService.createAProduct(createProductRequestDto);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException ex) { // why only in service exception and not in repo?? due to void???
            return ResponseEntity.status(400).build();
        } catch(Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateAProduct(@PathVariable("productId") int productId,
                                                  @RequestBody UpdateProductRequestDto updateProductRequestDto) {
        log.info("received a request to update a product with id {} {}", productId, updateProductRequestDto);
        try {
            Product product = productService.updateAProduct(productId, updateProductRequestDto);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch(Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteAProduct(@PathVariable("productId") int productId) {
        log.info("received a request to delete a product with id {} {}", productId);
        try {
            Product product = productService.deleteAProduct(productId);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }
}
