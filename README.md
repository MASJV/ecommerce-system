# 🛒 E-Commerce System

## 📚 Table of Contents

1. [Project Overview](#project-overview)
2. [Technology Stack](#technology-stack)
3. [🚀 Setup Instructions](#setup-instructions)
4. [Features & Backend Logic](#features--backend-logic)
5. [🌐 API Endpoints](#api-endpoints)
6. [⚠️ Exception Handling](#exception-handling)
7. [📦 Data Models](#data-models)
8. [🧪 Postman Collection](#postman-collection)
9. [🤝 Contribution Guidelines](#contribution-guidelines)

---

## 📝 Project Overview

A robust **backend system** for e-commerce, enabling the management of products, users, reviews, shopping carts, and orders.

- RESTful APIs built with Spring Boot and standard Java.
- Designed for educational, demonstration, or prototyping contexts—using in-memory lists for data storage.
- Clean separation of controllers, services, repositories, and DTOs.
- Carefully structured business rules: stock checks, review restrictions, cart logic.

---

## 💻 Technology Stack

- **Java 17+**
- **Spring Boot**
- **Lombok**
- **Maven/Gradle**
- **Postman** (for API testing)

---

## 🚀 Setup Instructions

1. **Clone the repository**
    ```
   git clone https://github.com/MASJV/ecommerce-system.git
   cd ecommerce-system
   ```

2. **Verify Java and build tool versions**
    ```
   java -version
   mvn -v # or gradle -v
   ```


3. **Build the project**
- Maven:
  ```
  mvn clean install
  ```
- Gradle:
  ```
  ./gradlew build
  ```

4. **Run the application**
- Maven:
  ```
  mvn spring-boot:run
  ```
- Or just run the main class from your IDE.

5. **Access REST APIs**
- Base URL: `http://localhost:8081/api/v1/`

---

## ⚙️ Features & Backend Logic

- **Product Management:** CRUD operations, live average ratings, stock update on orders.
- **User Management:** CRUD operations, personal cart and order history.
- **Cart & Order Logic:** Add/remove products, validate stock and quantities, place orders.
- **Reviews:** Only ordered products can be reviewed, one review per product per user; removing/adding reviews updates average product rating.
- **Robust Exception Handling:** Custom exceptions clarify invalid operations or missing data.

---

## 🌐 API Endpoints

_All API paths are prefixed with `/api/v1`._

| Section  | Method | Endpoint | Description                |
|----------|--------|----------|----------------------------|
| Product  | GET    | /products | Get all products          |
|          | GET    | /products/{id} | Get product by ID         |
|          | POST   | /products | Create product            |
|          | PATCH  | /products/{id} | Update product           |
|          | DELETE | /products/{id} | Delete product           |
| User     | GET    | /users    | Get all users             |
|          | GET    | /users/{id} | Get user by ID             |
|          | POST   | /users    | Create user               |
|          | PATCH  | /users/{id} | Update user name           |
|          | DELETE | /users/{id} | Delete user                |
|          | PATCH  | /users/{id}/cart | Add to cart             |
|          | POST   | /users/{id}/cart/orderCart | Place cart order |
|          | DELETE | /users/{id}/cart | Remove from cart         |
| Review   | GET    | /reviews  | Get all reviews           |
|          | GET    | /reviews/{id} | Get review by ID         |
|          | POST   | /reviews  | Create review             |
|          | PATCH  | /reviews/{id} | Update review             |
|          | DELETE | /reviews/{id} | Delete review             |

_Request and response bodies use standard DTOs as in your code._

---

## ⚠️ Exception Handling

| Exception                            | Reason                                          |
|--------------------------------------|-------------------------------------------------|
| ProductNotFoundException             | Product not found                               |
| UserNotFoundException                | User not found                                  |
| ReviewNotFoundException              | Review not found                                |
| ReviewAlreadyExistsException         | Duplicate review (same user & product)          |
| ProductNotOrderedException           | Review attempted without a prior order          |
| InsufficientProductQuantityException | Cart/order quantity exceeds available stock     |
| CartEmptyException                   | (Reserved for shop-cart errors)                 |
| InvalidRatingException               | Thrown when a review rating is outside the valid range (e.g., not between 0 and 10)                 |

_Status codes: 200 (OK), 400 (Bad Request), 404 (Not Found), 500 (Server Error)._

---

## 📦 Data Models

- **Product**: productId, name, description, quantity, avgRating, totalRating, reviews.
- **User**: userId, name, birthYear, country, cart (product list), orderHistory.
- **Review**: reviewId, productId, userId, productName, description, rating.
- **DTOs**: Cleanly defined for each request type per your code.

---

## 🧪 Postman Collection

Thoroughly tested all API endpoints using Postman.  
🔗 **Published Postman collection link below:**
https://documenter.getpostman.com/view/44008443/2sB3BBqXPe


---

## 🔮 Future Enhancements

This project provides a strong foundation, and here are some valuable features and improvements planned for future versions:

- **Authentication & Authorization:**  
  Implement user login, JWT or OAuth2 security, roles, and permissions for protected endpoints.

- **Persistent Storage:**  
  Replace in-memory lists with a database such as MySQL, PostgreSQL, or MongoDB for data persistence and scalability.