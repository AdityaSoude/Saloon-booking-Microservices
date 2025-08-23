# 💇 Saloon Booking — Microservices

A distributed **salon booking system** built with modern microservices patterns.  
This project was created **for learning Spring Boot and microservice architecture** by implementing real-world concepts like service discovery, API gateway, authentication, inter-service communication, and messaging.

---

## 📂 Modules

- **booking** — Customer bookings and appointment management  
- **category** — Service categories (e.g., hair, spa, grooming)  
- **eurekaserver** — Service discovery registry for all microservices  
- **gateway-server** — Central entry point for routing API requests  
- **notifications** — Sends confirmations and alerts via RabbitMQ  
- **salon** — Salon details and profiles  
- **service-offering** — Services and pricing offered by salons  
- **user-service** — User registration, authentication, and profiles (secured via Keycloak)  

---

## ⚙️ Tech Stack

- **Spring Boot** — Core microservices framework  
- **Spring Cloud Eureka** — Service discovery  
- **Spring Cloud Gateway** — API routing and load balancing  
- **Keycloak** — Authentication & authorization (OAuth2, JWT)  
- **RabbitMQ** — Message broker for async communication & notifications  
- **Feign Client** — Simplified inter-service communication  
- **MySQL** — Relational database for persistent storage  
- **Docker & Google Jib** — Containerization and image builds  
- **Maven/Gradle** — Build and dependency management  

---

## ✨ Features

- Modular, independently deployable services  
- Secure authentication/authorization with **Keycloak**  
- Centralized API Gateway with service discovery  
- **RabbitMQ** integration for reliable async messaging  
- **Feign Client** for clean inter-service calls  
- Database-backed persistence with **MySQL**  
- Container-ready with **Docker + Jib**  
- Extensible design for scaling features  

---
