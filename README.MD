# Order Management System Technical Documentation
![Order Management System](/sqlflow.pnf)

## Table of Contents
1. [Introduction](#introduction)
2. [System Overview](#system-overview)
3. [Architecture](#architecture)
  - [Backend (Spring Boot)](#backend-spring-boot)
  - [Database (PostgreSQL via Docker Compose)](#database-postgresql-via-docker-compose)
  - [Frontend (React + TypeScript with Vite)](#frontend-react--typescript-with-vite)
4. [Requirements Traceability](#requirements-traceability)
5. [Design & Implementation](#design--implementation)
  - [Domain Models](#domain-models)
  - [Repositories](#repositories)
  - [Services](#services)
  - [Controllers & API Endpoints](#controllers--api-endpoints)
  - [Security Configuration](#security-configuration)
6. [Flow Chart & SQL ERD](#flow-chart--sql-erd)
7. [Build, Deployment, and Testing](#build-deployment-and-testing)
8. [Future Enhancements](#future-enhancements)
9. [Appendix](#appendix)



## 1. Introduction

The Order Management System is a web application that allows customers to:
- View all available products (with detailed descriptions, reviews, and ratings)
- Filter products by category and view product details without logging in
- Place orders after logging in (the system checks product availability and collects customer details such as first name, last name, city, street, landmark, state, pin, phone number)
- Track transactions related to orders (payment details, method, and status)
- Delivery agents receive order details for fulfillment

This document outlines the technical design, architecture, and implementation details.



## 2. System Overview

- **Backend:** Spring Boot RESTful API handling CRUD operations for products, users, orders, and transactions.
- **Database:** PostgreSQL running in a Docker container (via Docker Compose).
- **Frontend:** A React application written in TypeScript and built with Vite. It provides a responsive UI with search, sorting, and toast notifications.
- **Security:** Basic form-based login with in-memory authentication (demo mode).



## 3. Architecture

### Backend (Spring Boot)
- **Framework:** Spring Boot
- **Components:**
  - **Domain Models:** Product, User, Order, OrderDetail, Transaction
  - **Repositories:** Extend `JpaRepository` for standard CRUD operations
  - **Services:** Business logic (e.g., product availability, order processing, transaction creation)
  - **Controllers:** REST endpoints exposing CRUD operations for each entity

### Database (PostgreSQL via Docker Compose)
- **Engine:** PostgreSQL
- **Deployment:** Managed by Docker Compose (exposes port 5432)
- **Configuration:** Defined in `application.properties`

### Frontend (React + TypeScript with Vite)
- **Framework:** React with TypeScript
- **Build Tool:** Vite
- **Features:**
  - CRUD interfaces for products, users, orders, and transactions
  - Search and sortable tables for data display
  - Toast notifications for feedback
  - Responsive, modern UI



## 4. Requirements Traceability

### Functional Requirements
- **Product Management:**
  - View all products, filter by category, view product details.
  - Add, update, and delete products.
- **Order Processing:**
  - Place orders after logging in.
  - Validate product availability.
  - View, update, and delete orders.
- **User Management:**
  - Register new users.
  - Login required for order placement.
  - View, update, and delete user details.
- **Transaction Management:**
  - Record payment details for orders.
  - View, update, and delete transactions.

### Non-Functional Requirements
- **Performance:** Fast API responses and a responsive UI.
- **Security:** Basic authentication with form login; public access for product viewing.
- **Usability:** Clear navigation, searchable and sortable tables, toast notifications.
- **Maintainability:** Modular, well-documented components.

*Mapping:*
- Domain models and repositories support the business entities.
- Controllers map functional requirements to REST endpoints.
- The frontend implements required UI features.



## 5. Design & Implementation

### Domain Models
- **Product:** `name`, `description`, `category`, `price`, `quantityAvailable`, `rating`
- **User:** `username`, `password`, `firstName`, `lastName`, `city`, `street`, `landmark`, `state`, `pin`, `phoneNumber`
- **Order:** References a User, contains an order date, status, and a list of OrderDetails.
- **OrderDetail:** Associates a Product with an Order (includes quantity and price).
- **Transaction:** References an Order, includes transaction date, amount, payment method, and status.

### Repositories
- Each model extends `JpaRepository<T, ID>`.
- Example: `ProductRepository` with `findByCategory(String category)`.

### Services
- **OrderService:** Checks product availability and processes orders.
- **TransactionService:** Creates and manages transactions.

### Controllers & API Endpoints

#### ProductController
- **POST /api/products:** Create product
- **GET /api/products:** List products
- **GET /api/products/{id}:** Get product details
- **GET /api/products/category/{category}:** Filter products by category
- **PUT /api/products/{id}:** Update product
- **DELETE /api/products/{id}:** Delete product

#### UserController
- **POST /api/users:** Register user
- **GET /api/users:** List users
- **GET /api/users/{id}:** Get user details
- **PUT /api/users/{id}:** Update user
- **DELETE /api/users/{id}:** Delete user

#### OrderController
- **POST /api/orders:** Place order
- **GET /api/orders:** List orders
- **GET /api/orders/{id}:** Get order details
- **PUT /api/orders/{id}:** Update order
- **DELETE /api/orders/{id}:** Delete order

#### TransactionController
- **POST /api/transactions:** Create transaction
- **GET /api/transactions:** List transactions
- **GET /api/transactions/{id}:** Get transaction details
- **PUT /api/transactions/{id}:** Update transaction
- **DELETE /api/transactions/{id}:** Delete transaction

### Security Configuration
- Uses Spring Security with form-based login.
- In-memory authentication (username: `user`, password: `password`).
- Public endpoints: `/api/register`, `/api/products/**` are accessible; others require authentication.

### Frontend Components & Features
- **Navigation:** Switch between Products, Users, Orders, and Transactions.
- **Data Display:** Data is shown in searchable, sortable tables.
- **Row Selection:** Clicking a row displays detailed information.
- **Forms:** For adding products, registering users, placing orders, and creating transactions.
- **Toast Notifications:** Feedback on operations (success/error).




## 6. Flow Chart & SQL ERD

![SQL/ERD and Flow Chart ](/sqlflow.pnf)

## 7. Build, Deployment, and Testing


### Build Process
- **Backend:** Run `mvn clean install` from the project root.
- **Frontend:** Build with Vite (`npm run build`) and copy output to `src/main/resources/static`.

### Deployment
- **PostgreSQL:**  
  Use Docker Compose:
  ```bash
  docker-compose -f docker-compose.yml up -d




## Gap Analysis

### Current State
- **Feature Set:** Users can view products, place orders, and process basic transactions.
- **Technology:** Built using Spring Boot (or JSP/Servlet), with basic authentication.
- **Security:** Form-based login with in-memory authentication.

### Desired Future State
- **Enhanced User Experience:**
  - Real-time notifications.
  - Detailed analytics and reporting dashboards.
- **Advanced Security:**
  - Token-based authentication (e.g., JWT).
  - Role-based access control.
- **Improved Performance:**
  - Scalability enhancements for high traffic scenarios.

### Identified Gaps
- **User Experience:**
  - Missing real-time notifications.
  - Limited analytics and reporting.
- **Security:**
  - Current authentication method is basic.
  - Lack of role management.
- **Performance:**
  - Room for scalability improvements.
