# Online Retail Store Application

# Problem statement 
Build the domain model only for a checkout counter in an online retail store that scans products and
generates an itemized bill.
The bill should also total the cost of all the products and the applicable sales tax for each product.
The total cost and total sales tax should be printed
Sales tax varies based on the type of products
- Category A products carry a levy of 10%
- Category B products carry a levy of 20%
- Category C products carry no levy

## Features
- REST API
- JWT authentication
- Swagger-ui documentation

## Technology Stacks
**Backend**
  - Java 8
  - Spring Boot 1.4.7
  - Spring Security
  - JWT Authentication
  - Spring Data JPA
  - h2 database
  - Maven

# REST endpoints
http://localhost:8090/swagger-ui.html#/ 
*to check bill
GET /bills
GET /bill/{id}
#(port used- 8090)


## authentication
username-admin	
password - admin


# How to run the application locally?

Pre-requisites to run application are Java, git and maven.
*  Apache Maven 3.5.0 
*  Java version: 1.8

# How to build & run?
1. Open commandline terminal
2. Clone repository using following command 
  git clone https://github.com/jnandurkar/OnlineRetailStore.git 
3. Build the jar using maven=> mvn package  
4. Go to target folder => cd target
5. Run following command to start the server on port 8090=> java -jar OnlineRetailStore-0.0.1-SNAPSHOT.jar (For other port number, Please change port number in application.properties file)
Optionally, one can configure port using commandline parameter => --server.port=8080
6. Access and invoke APIs using url => http://localhost:8090/swagger-ui.html
7. For authentication credential, Use 'admin' as user id and password.

This application developed using H2 database and hence does not persist data after application restarts. 

