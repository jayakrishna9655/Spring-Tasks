# Product Management System

A RESTful backend service built with **Spring Boot**, **Spring Data JPA**, and **MySQL** for managing products and warehouse inventory.

---

## 🚀 Features

- **Add Product**: Save new product records with name, price, and quantity.
- **Get All Products**: Retrieve all products currently stored in the database.
- **Get Product By ID**: Fetch product details by its unique identifier.
- **Database Persistence**: Automatic schema management and relational persistence using JPA/Hibernate with MySQL.

---

## 🛠️ Tech Stack

- **Java**: 17
- **Framework**: Spring Boot 3+ (Spring Web, Spring Data JPA)
- **Database**: MySQL
- **Build Tool**: Maven

---

## 📂 Project Structure

```
productManagement/
├── src/
│   ├── main/
│   │   ├── java/com/jai/productManagement/
│   │   │   ├── Controller/      # REST API Controllers (productController.java)
│   │   │   ├── Entity/          # JPA Entity definitions (productEntity.java)
│   │   │   ├── Repository/      # Spring Data JPA Repositories (productRepository.java)
│   │   │   ├── Service/         # Business logic layer (productService.java)
│   │   │   └── ProductManagementApplication.java # Spring Boot Main Class
│   │   └── resources/
│   │       └── application.properties # App & Database configurations
│   └── test/
├── pom.xml
└── README.md
```

---

## ⚙️ Configuration & Setup

### 1. Prerequisites
- **JDK 17** or later installed
- **MySQL Server** installed and running
- **Maven** (or use the included `./mvnw` wrapper)

### 2. Database Configuration
Create a database in MySQL:
```sql
CREATE DATABASE spring_tast;
```

Update your database credentials in `src/main/resources/application.properties` if needed:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_tast?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build & Run
Run the application using Maven:
```bash
# Windows
mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

The server will start at `http://localhost:8080`.

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/` | Health check endpoint |
| `POST` | `/api/products` | Add a new product |
| `GET` | `/api/products` | Retrieve all products |
| `GET` | `/api/products/{ID}` | Retrieve a product by ID |
| `DELETE` | `/api/products/{ID}` | Delete a product by ID (204 No Content / 404 Not Found) |

---

### Request & Response Examples

#### 1. Add Product (`POST /api/products`)
**Request Body:**
```json
{
  "name": "Wireless Mouse",
  "price": 24.99,
  "quantity": 50
}
```

**Response (`200 OK`):**
```json
{
  "id": 1,
  "name": "Wireless Mouse",
  "price": 24.99,
  "quantity": 50
}
```

#### 2. Get All Products (`GET /api/products`)
**Response (`200 OK`):**
```json
[
  {
    "id": 1,
    "name": "Wireless Mouse",
    "price": 24.99,
    "quantity": 50
  }
]
```

#### 3. Get Product By ID (`GET /api/products/1`)
**Response (`200 OK`):**
```json
{
  "id": 1,
  "name": "Wireless Mouse",
  "price": 24.99,
  "quantity": 50
}
```

---

## 👤 Author
- **Jayakrishna** ([@jayakrishna9655](https://github.com/jayakrishna9655))
