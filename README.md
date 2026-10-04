# Food Delivery Microservices

A simple food delivery backend project built using Java, Spring Boot,
Spring Cloud, Eureka Server, MySQL and OpenFeign.

## Microservices

### 1. FoodEurekaServer
- Eureka Service Registry
- Port: 8761

### 2. UserClient
- User registration
- User login
- Get user details
- Port: 8081

### 3. RestaurantClient
- Add restaurant
- Get restaurants
- Edit restaurant
- Delete restaurant
- Add food
- Get food details
- Port: 8082

### 4. OrderClient
- Place order
- View orders
- View user orders
- Update order status
- Uses OpenFeign to communicate with other services
- Port: 8083

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Cloud Eureka
- OpenFeign
- MySQL
- Maven
- Postman
- Git & GitHub

## Project Flow

User Registration/Login
        ↓
Restaurant
        ↓
Food
        ↓
Place Order
        ↓
View Orders
        ↓
Update Order Status

## Database

Each microservice uses a separate MySQL database:

- fooduser
- foodrestaurant
- foodorder

## How to Run

1. Start `FoodEurekaServer`
2. Start `UserClient`
3. Start `RestaurantClient`
4. Start `OrderClient`
5. Use Postman to test the APIs

## Ports

| Service | Port |
|---|---:|
| FoodEurekaServer | 8761 |
| UserClient | 8081 |
| RestaurantClient | 8082 |
| OrderClient | 8083 |

## Author

ARIKARAN M.