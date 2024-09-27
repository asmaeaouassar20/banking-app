# banking-app
Build REST APIs for a simple Banking application

This project is a simple Banking Application built with Spring Boot.
It provides basic functionalities for managing bank accounts, such as creating an account,
fetching account details, and performing transactions (deposit/withdrawal)

# Features
- Create a Bank Account
- Make a Deposit
- Withdraw an Amount
- Fetch All Accounts
- Delete an ACcount by ID

# Technologies Used
- Spring Boot Version : 3.3.4
- Spring Web : For building the RESTful APIs
- Spring Data JPA : For database interactions
- MySQL Driver : For connecting to the MySQL database.
- Lombok : To reduce boilerplate (modèle standard) code for model object

# Project Structure
The project follows a layered architecture:
- **Controller** : Handles HTTP requests and responses.
- **DTO (Data Transfer Object)** : Defines how data is transferred between layers.
- **Entity** : Represents the data structure for the database.
- **Mapper** : Converts JPA entities to DTOs and vice versa.
- **Repository** : Interacts with the database.
- **Service** : Contains the business logic.  

# Prerequisites
- Java 17 or higher
- MySQL
- Intellij IDEA (or any Java IDE)
- Postman (for testing the APIs)<br>
<img src="https://github.com/user-attachments/assets/d967367b-b5d9-424f-9f94-cac7108d519d" alt="postman screenshot"> <br>
postman screenshot

# Tools Used
- **Spring Initializr** : to generate the initial project structure.
- **IntelliJ IDEA** : for developing the application.
- **Postman** : for testing the API requests.

# Future Improvements
- Add user authentication and authorization (Spring Security)
- Implement additional transaction rtypes (transfer between accounts)
- Add detailed logging and exception handling

