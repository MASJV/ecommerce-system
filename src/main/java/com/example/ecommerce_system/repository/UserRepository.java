package com.example.ecommerce_system.repository;

import com.example.ecommerce_system.exception.InsufficientProductQuantityException;
import com.example.ecommerce_system.exception.ProductNotFoundException;
import com.example.ecommerce_system.exception.UserNotFoundException;
import com.example.ecommerce_system.model.entity.Product;
import com.example.ecommerce_system.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository

public class UserRepository implements IUserRepository{
    private List<User> userList;
    private final ProductRepository productRepository;

    public UserRepository(ProductRepository productRepository) {

        userList = new LinkedList<>();
        this.productRepository = productRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userList;
    }

    @Override
    public User getAUser(int userId) throws UserNotFoundException {
        for(User user : userList) {
            if(user.getUserId() == userId) {
                return user;
            }
        }
        throw new UserNotFoundException("User Not Found");
    }

    @Override
    public void createAUser(User user) {
        userList.add(user);
    }

    @Override
    public User updateAUser(int userId, String name) throws UserNotFoundException {
        for(User user : userList) {
            if(user.getUserId() == userId) {
                user.setName(name);
                return user;
            }
        }
        throw new UserNotFoundException("User Not Found");
    }

    @Override
    public User deleteAUser(int userId) throws UserNotFoundException{
        for(User user : userList) {
            if(user.getUserId() == userId) {
                userList.remove(user);
                return user;
            }
        }
        throw new UserNotFoundException("User Not Found");
    }

    @Override
    public void addToCart(User user, Product product, int quantity) throws InsufficientProductQuantityException{ // alternate way is to override .equals() method
        // when requested quantity is greater(exception)
        if(quantity > product.getQuantity()) throw new InsufficientProductQuantityException("Requested quantity not available in stock");
        boolean found = false;
        for(Product cartProduct : user.getCart()) {
            if(cartProduct.getProductId() == product.getProductId()) {
                if(cartProduct.getQuantity() >= product.getQuantity()) { // when cumulative quanity is greater(exception)
                    throw new InsufficientProductQuantityException("Requested quantity not available in stock");
                }
                cartProduct.setQuantity(cartProduct.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        if(!found) {
            Product cartProduct = new Product(product.getProductId(), product.getName(), product.getDescription(),
                    quantity, product.getReviews());
            // sets cartProduct id to productid
            cartProduct.setAvgRating(product.getAvgRating());
            cartProduct.setTotalRating(product.getTotalRating());
            user.addToCart(cartProduct);
        }
    }


    @Override
    public List<Product> placeOrderFromCart(int userId) throws UserNotFoundException, ProductNotFoundException {
        final User user = getAUser(userId); // final needed???
        for(Product product : user.getCart()) {
            Product pr = productRepository.getAProduct(product.getProductId());
            pr.setQuantity(pr.getQuantity() - product.getQuantity()); // negative exception to be addeddddddd
            // the actual product quantity should decrease by cart product quantity
        }
        List<Product> order = new ArrayList<>(user.getCart());
        for (Product p : user.getCart()) {
            user.addToOrderHistory(p);
        }
        user.getCart().clear();
        return order;
    }

    @Override
    public void deleteFromCart(User user, Product product, int quantity) throws ProductNotFoundException, InsufficientProductQuantityException{
        boolean found = false;
        for(Product cartProduct : user.getCart()) {
            if(cartProduct.getProductId() == product.getProductId()) {
                if(cartProduct.getQuantity() < quantity){
                    throw new InsufficientProductQuantityException("Cannot remove the specified quantity: " +
                            "you only have " + cartProduct.getQuantity() + " of this item in your cart.");
                }
                else{
                    cartProduct.setQuantity(cartProduct.getQuantity() - quantity);
                    if(cartProduct.getQuantity() == 0) {
                        user.getCart().remove(cartProduct);
                    }
                }
                found = true;
                break;
            }
        }
        if(!found) {
            throw new ProductNotFoundException("Product Not Found");
        }
    }

}
