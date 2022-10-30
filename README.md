# Technical Challenge Documentation

## Description
I sued the following modules in the project:
* Spring Data: for the connection with MySQL database and the entities management with Hibernate
* Spring Security: authorization and authentication with Basic Authentication mode
* Spring Web: for the configuration and required dependencies in order to build and execute a REST API

## Get Started
### Clone the repository and download the dependencies
To run the server you can clone this repository in your local machine and run the command `mvnw install` for downloading the dependencies or `mvnw spring-boot:run` with DevTools enabled.

### Database Connection
In application.properties file you can indicate the URL, username and password of your database. I use the following configuration for a Test DB in a remote server:
```
spring.datasource.url = jdbc:mysql://db4free.net:3306/metaphorcebd
spring.datasource.username = metaphorce
spring.datasource.password = m3t4Ph0rc3
```

Note: The database is a Test Database, so this DB will be deleted in November 12th, 2022.

Also you need to indicate the driver:
```
spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
```

### Security Configuration
In application.properties file you can define the credentials for the Basic Authentication:
```
spring.security.user.name = metaphorce
spring.security.user.password = m3t4Ph0rc3
```

Now you can run the local server to test the endpoints.

Optionally, you can define the DDL mode as create-drop: `spring.jpa.hibernate.ddl-auto = create-drop`

### Global Configuration

In my case, I configured the server port as 9000 in application properties file: `server.port = 9000`

## Endpoints
There are 5 endpoints:
* `/api/employee/all`
    - URL Params: None
    - Request: None
    - Returns: A List of AllEmployeesResponse object:
        + String fullName
String email
String taxIdNumber
        + String String contractName
        + Date contractDateFrom
        + Date contractDateTo
        + Double salaryPerDay
    - HTTP Status: CREATED
* `/api/contract/add`
    - URL Params:
        + String taxIdNumber
    - Request: The RequestBody must to have:
        + String contractTypename
        + Date dateFrom
        + Date dateTo
        + Double salaryPerDay
    - Returns: None
    - HTTP Status: CREATED
* `/api/employee/create`
    - URL Params: None
    - Request:
        + String taxIdNumber
        + String name
        + String lastname
        + Date birthdate
        + String cellPhone
        + String email
    - Returns: None
    HTTP Status: CREATED
* `/api/employee/update`
    - URL Params: None
    - Request:
        + String taxIdNumber
        + String name
        + String lastname
        + Date birthdate
        + String cellPhone
        + String email
    - Returns: None
    HTTP Status: CREATED
* `/api/contract/disable`
    - URL Params:
        + String taxIdNumber
    - Request: None
    - Returns: None
    - HTTP STATUS: OK