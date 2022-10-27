# STOCK MANAGEMENT MICROSERVICE
===============================================

A simple REST Application which manages the product stock in an E-Shop
---

In the app a user works with these functions;

(The Product has a predefined initial stock of 100)

* The whole product information for insertion
* The stock of a product for getting the stock
* Can Refill the product stock
* Buying the product decreases the stock
* Product can be reserved for a specified time and must be released (back to stock) after it, if it hasn't been bought.

! It is not allowed to buy a product more than its stock

---

`Spring-boot`, `Maven` is used as the main tool for developing project. Those help us to focus on business more.

This project follows the `RESTFUL` best practices exposing needed endpoints

---

The business is so simple that code should be kept simple. So it should be avoided to implement strange concepts

Hopefully this project will be continued in order to implement other concepts.

---


** Getting started**
---
Retrieve Sources

    https://github.com/mfarahani31/StockManagement

Launch the application

    $ mvn spring-boot:run

### APIs

Method | Path           | Description                    |
-------|----------------|--------------------------------|
GET    | /api/v1/products      | retrieve all products|
GET    | /api/v1/products/{productId} | retrieve a specific product by its Id|
POST   | /api/v1/products   | save a product info|
GET    | /api/v1/products/{productId}/getStock| retrieve the current stock of a product|
PATCH  | /api/v1/products/{productId}/refill| refill the stock of a product|
POST   | /api/v1/products/{productId}| buy a product|

---

See full document of APIs on swagger-ui ;

on [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)



** And also you can see the database tables on 

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)


---
The tools that were used in this project;


- Java v11
- Spring-boot v2.6.2
- Spring-boot data jpa ; for persistence layer
- Spring-boot dev tools
- H2 database
- Lombok
- Spring-boot test; for write unit test and integration test (`All lines are covered with coverage of 100%`)
- Swagger; for documenting APIs
- Mapstruct; for mapping DTOs
- Flyway; for database versioning
- Maven; as the build tool
---


