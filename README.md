📘 README.md — Backend (Spring Boot + Redis)
# URL Shortener Backend

This project is a backend service for a URL shortener built using **Spring Boot** and **Redis**.
It generates short, unique keys for long URLs and redirects users to the original URL with low latency.

The project is created for **learning backend development**, focusing on REST APIs, Redis, Docker, and clean architecture.

---

## How the System Works

1. Client sends a long URL to the backend
2. Backend generates a unique numeric ID using Redis
3. The ID is converted into a short Base62 string
4. Redis stores the mapping: shortKey → originalUrl
5. When the short URL is accessed, the backend redirects the user to the original URL

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Web (REST APIs)
- Spring Data Redis
- Redis
- Docker & Docker Compose

---

## Project Structure



src/main/java/com/example/urlShorty
├── controller
│ └── UrlController.java
├── service
│ ├── UrlShortenerService.java
│ └── KeyGenerator.java
└── config
└── RedisConfig.java


---

## Core API Endpoints

### Shorten URL



POST /api/shorten?url=<longUrl>


**Example**


POST /api/shorten?url=https://google.com


**Response**


g


---

### Redirect to Original URL



GET /api/{shortKey}


**Example**


GET /api/g


Redirects to:


https://google.com


---

## Redis Data Model



global:id -> 1024
g -> https://google.com

h -> https://github.com


Redis is used as a fast key-value store with atomic ID generation.

---

## Why Base62 Encoding?

- URL-safe characters
- Short and compact keys
- Used by real-world URL shorteners (e.g., Bitly)

---

## Docker Support

The backend and Redis can be started together using:



docker compose up --build


This starts:
- Backend on port 8080
- Redis on port 6379

---

## Learning Outcomes

- REST API design
- Redis atomic operations
- Base62 encoding
- Dockerized backend services
- Frontend-backend integration

---

## Author

**raZer**