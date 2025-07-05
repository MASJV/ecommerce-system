package com.example.ecommerce_system.repository;

import com.example.ecommerce_system.exception.InsufficientProductQuantityException;
import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.exception.UserNotFoundException;
import com.example.ecommerce_system.model.entity.Product;
import com.example.ecommerce_system.model.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAllUser();
    User getAUser(int userId) throws UserNotFoundException;
    void createAUser(User user);
    User deleteAUser(int userId) throws UserNotFoundException;
    User updateAUser(int userId, String name) throws UserNotFoundException;
    void addToCart(User user, Product product, int quantity) throws InsufficientProductQuantityException;
    List<Product> placeOrderFromCart(int userId) throws UserNotFoundException, ProductNotFoundException;
    void deleteFromCart(User user, Product product, int quantity) throws ProductNotFoundException, InsufficientProductQuantityException;
}
