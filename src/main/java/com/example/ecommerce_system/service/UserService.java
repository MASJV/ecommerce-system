package com.example.ecommerce_system.service;


import com.example.ecommerce_system.exception.InsufficientProductQuantityException;
import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.exception.UserNotFoundException;
import com.example.ecommerce_system.model.dto.AddToCartDto;
import com.example.ecommerce_system.model.dto.CreateUserRequestDto;
import com.example.ecommerce_system.model.dto.DeleteFromCartDto;
import com.example.ecommerce_system.model.dto.UpdateUserRequestDto;
import com.example.ecommerce_system.model.entity.Product;
import com.example.ecommerce_system.model.entity.User;
import com.example.ecommerce_system.repository.IProductRepository;
import com.example.ecommerce_system.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserService {
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;

    public List<User> getAllusers() {
        return userRepository.getAllUser();
    }

    public User getAUser(int userId) throws UserNotFoundException{
        return userRepository.getAUser(userId);
    }

    public User createAUser(final CreateUserRequestDto createUserRequestDto) throws UserNotFoundException {
        final User user = new User(createUserRequestDto.getName(), createUserRequestDto.getBirthYear(),
                                    createUserRequestDto.getCountry());
        userRepository.createAUser(user);
        return user;
    }

    public User deleteAUser(int userId) throws UserNotFoundException{
        return userRepository.deleteAUser(userId);
    }

    public User updateAuser(int userId, final UpdateUserRequestDto updateUserRequestDto) throws UserNotFoundException{
        return userRepository.updateAUser(userId, updateUserRequestDto.getName());
    }

    public User addToCart(int userId, final AddToCartDto addToCartDto) throws UserNotFoundException, ProductNotFoundException, InsufficientProductQuantityException {
        final Product product = productRepository.getAProduct(addToCartDto.getProductId());
        final int quantity = addToCartDto.getQuantity();
        // check if requested quantity <= actual quantity of product
        if(quantity > product.getQuantity()) {
            throw new InsufficientProductQuantityException("Requested quantity is unavailable");
        }
        final User user = userRepository.getAUser(userId);
        userRepository.addToCart(user, product, quantity);
        return user;
    }

    public List<Product> placeOrderFromCart(int userId) throws UserNotFoundException, ProductNotFoundException{
        return userRepository.placeOrderFromCart(userId);
    }

    public User deleteFromCart(int userId, final DeleteFromCartDto deleteFromCartDto) throws UserNotFoundException, ProductNotFoundException, InsufficientProductQuantityException{
        final User user = userRepository.getAUser(userId);
        // product repo import here or in user repo???(have done both here respectively but recommended)??
        final Product product = productRepository.getAProduct(deleteFromCartDto.getProductId());
        userRepository.deleteFromCart(user, product, deleteFromCartDto.getQuantity());
        return user;
    }
}
