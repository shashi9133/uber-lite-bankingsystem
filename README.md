# 🚀 Uber Backend System (Microservices Architecture)

A production-style **microservices-based backend system** inspired by real-time platforms, built using **Spring Boot, Kafka, Docker, Kubernetes, and AWS**.

---

## 📌 Project Overview

This project simulates a scalable backend system similar to real-world ride-sharing / banking platforms.
It follows **microservices architecture** with **event-driven communication** using Kafka.

---

## 🏗️ Architecture

* **API Gateway** – Single entry point for all client requests
* **Service Discovery** – Eureka Server
* **Microservices**:

  * User Service
  * Driver Service
  * Trip Service
  * Payment Service
  * Notification Service
* **Messaging** – Kafka (Event-driven communication)
* **Database** – MySQL
* **Containerization** – Docker
* **Orchestration** – Kubernetes
* **Cloud Deployment** – AWS EC2
* **Ingress** – External traffic routing

---

## ⚙️ Tech Stack

* **Backend**: Java, Spring Boot, Spring Cloud
* **Messaging**: Apache Kafka
* **Database**: MySQL
* **DevOps**: Docker, Docker Compose, Kubernetes
* **Cloud**: AWS (EC2)
* **Tools**: Git, GitHub, Postman

---

## 🔄 System Flow (How it works)

1. Client sends request → API Gateway
2. Gateway routes to appropriate microservice
3. Services communicate via REST (sync) or Kafka (async)
4. Events (like trip/payment) are published to Kafka
5. Notification & other services consume events
6. Response returned to client

---

## 🐳 Docker Setup (Local)

```bash
# Build and start all services
docker-compose up --build
```

---

## ☸️ Kubernetes Deployment

```bash
# Apply all Kubernetes configurations
kubectl apply -f kubernetes/
```

### Check pods:

```bash
kubectl get pods
```

### Check services:

```bash
kubectl get svc
```

---

## 🌐 Ingress Access

* Ingress is configured to route external traffic to services
* Access system via configured domain/IP

---

## 📂 Project Structure

```
uber-backendSystem/
│
├── api-gateway/
├── user-service/
├── driver-service/
├── trip-service/
├── payment-service/
├── notification-service/
│
├── docker-compose.yml
│
├── kubernetes/
│   ├── user-service.yaml
│   ├── driver-service.yaml
│   ├── trip-service.yaml
│   ├── kafka.yaml
│   ├── zookeeper.yaml
│   ├── mysql.yaml
│   ├── ingress.yaml
│
└── README.md
```

---

## 🔥 Key Features

* ✅ Microservices Architecture
* ✅ Event-Driven System using Kafka
* ✅ Dockerized Services
* ✅ Kubernetes Deployment
* ✅ AWS Cloud Hosting
* ✅ Scalable & Fault-Tolerant Design

---

## 💡 Challenges & Learnings

* Handling inter-service communication
* Managing container orchestration with Kubernetes
* Debugging deployment issues in cloud environments
* Understanding real-world distributed system design

---

## 🚀 Future Enhancements

* 🔐 Implement Authentication (JWT, Spring Security)
* 📊 Add Monitoring (Prometheus + Grafana)
* 🔁 CI/CD Pipeline (GitHub Actions / Jenkins)
* 📦 Use Helm Charts for Kubernetes

---

## 👨‍💻 Author

**Shashidhar Bathini**

* Java Full Stack Developer
* Passionate about Backend & DevOps

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
