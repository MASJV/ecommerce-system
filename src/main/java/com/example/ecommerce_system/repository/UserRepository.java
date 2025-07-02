package com.example.ecommerce_system.repository;

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
    public void addToCart(User user , Product product, int quantity) {
        Product cartProduct = new Product(product.getProductId(), product.getName(), product.getDescription(),
                quantity, product.getAvgRating(), product.getTotalRating());
        user.addToCart(cartProduct);
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
        user.getCart().clear();
        return order;
    }

}
