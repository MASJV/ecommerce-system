package com.example.ecommerce_system.controller;

import com.example.ecommerce_system.exception.InsufficientProductQuantityException;
import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.exception.UserNotFoundException;
import com.example.ecommerce_system.model.dto.AddToCartDto;
import com.example.ecommerce_system.model.dto.CreateUserRequestDto;
import com.example.ecommerce_system.model.dto.DeleteFromCartDto;
import com.example.ecommerce_system.model.dto.UpdateUserRequestDto;
import com.example.ecommerce_system.model.entity.Product;
import com.example.ecommerce_system.model.entity.User;
import com.example.ecommerce_system.service.ProductService;
import com.example.ecommerce_system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j // helps in logging
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createAUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        log.info("received a request to create a user with body {} ", createUserRequestDto);
        try {
            User user = userService.createAUser(createUserRequestDto); // why not final User user here?????
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
        // why exception even in creating user????
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteAUser(@PathVariable("userId") int userId) {
        log.info("received aq request to delete a user with id{} ", userId);
        try {
            return ResponseEntity.ok(userService.deleteAUser(userId));
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateAUser(@PathVariable("userId") int userId,
                                            @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        log.info("received a request to update a user with id {} {}", userId, updateUserRequestDto);
        try {
            User user = userService.updateAuser(userId, updateUserRequestDto);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{userId}/cart")
    public ResponseEntity<User> addToCart(@PathVariable("userId") int userId,
                                          @RequestBody AddToCartDto addToCartDto) {
        log.info("received a request to add product with id {} to cart of user with id {}", addToCartDto.getProductId(),
                userId);

        try {
            User user = userService.addToCart(userId, addToCartDto);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException | ProductNotFoundException | InsufficientProductQuantityException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/{userId}/cart/orderCart") // patch, post, get?????
    public ResponseEntity<List<Product>> placeOrderFromCart(@PathVariable("userId") int userId) {
        log.info("received a request to place order on items in cart");
        try {
            List<Product> finalOrder = userService.placeOrderFromCart(userId);
            return ResponseEntity.ok(finalOrder);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{userId}/cart") // same patchMaping not possible(in general idea) as for addtocart confusion
    public ResponseEntity<User> deleteFromCart(@PathVariable("userId") int userId,
                                               @RequestBody DeleteFromCartDto deleteFromCartDto) {
        log.info("received a request to delete product with id{} from cart of user with id {}",
                deleteFromCartDto.getProductId(), userId);
        try {
            User user = userService.deleteFromCart(userId, deleteFromCartDto);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException | ProductNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }
}
