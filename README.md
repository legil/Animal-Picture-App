# 🐾 This is an Animal Picture App

A simple Spring Boot application that fetches and returns animal pictures using public REST APIs. Built with Java and Docker for easy deployment.

The app returns image URLs of a cat, dog, or bear. It integrates with third-party APIs such as:

- [Cat as a service](https://cataas.com/)
- [Place Dog](https://placedog.net)
- [The Cat API](https://placebear.com)

---

## How to Run the App

### ✅ Prerequisites

- Java 17+
- Maven
- Docker (for containerization)


### To Run Locally (without Docker)

```bash
git clone https://github.com/your-username/animal-picture-app.git
cd animal-picture-app
mvn clean install
mvn spring-boot:run
````

The app will be available at:
http://localhost:8081


### 🐳 Run with Docker
```bash
docker build -t animal-picture-app .
docker run -p 8081:8081 animal-picture-app
````

### API Specification
**Method:** POST  
**Endpoint:**  /animals/pictures?animalType=cat&numberOfPictures=X       
**Purpose:** Saves X amount pictures of cats

**Method:** GET       
**Endpoint:** /animals/pictures/last/cat	                              
**Purpose:** Retrieves the last saved picture of a cat




### Tasks left to do on this app
- add unit testing
- persist db across reloads
- further server error handling


This app was built in Eclipse IDE.