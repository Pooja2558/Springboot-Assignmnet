### Spring boot CRUD example using JPA, MySQL Database
implement  CRUD operations with a Product entity.
Creates Product entity and save below product in Mysql database and perform CRUD operations on Product entity to add/update/delete products.
getProducts method will calculate the final price of each product based on discount and other charges table .


### Installation

### 1. You can clone it from github by running following command
```
$ git clone https://github.com/Pooja2558/Assignment.git
```
### 2. Import project into eclipse

  File -> open project from file system -> Directory ->  select Project folder from cloned location
### 3. Right click on project in eclipse and then Maven -> Update Projects
### 5. Update database credential and other configuration into application.properties available in src/main/java/resources
```
#changing the server port
server.port=8088
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/product
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

```
### 6. Right click on ProductAssignmentApplication.java file and run as Java Application

### Once Sprint Boot Application will be started successfully then we 
can call following Endpoints by using POSTMAN

### 7. To get list of Products call following endpoint with GET Request
```
  http://localhost:8088/fetchAllProducts
```
### 8.To Create New Product use following url with POST Request
```
  http://localhost:8088/addProduct
```

### set request body as raw with JSON payload
```
 {  
        "name": "Study table",
        "productType": "Furniture",
        "basePrice": 3333.33,
        "category": "Furniture"
 }

```
### 9.To get a particular product, use following url with `GET` request type in postman
```
  http://localhost:8088/getProducts/<pid>
```
### 10.To update product in database, use following url with `PUT` request type in postman
```
	http://localhost:8080/update/<id>
```
### set request body as raw with JSON payload

```
{  "productId": 3,
        "name": "Study table",
        "productType": "Furniture",
        "basePrice": 3333.33,
        "category": "Furniture"
      
        }
```
### 11.To delete a particular Product from database, use following url with `DELETE` request type in postman
```
  http://localhost:8080/delete/<id>
```
###  hit the URL in your web browser and see the Swagger API functionalities.
```
http://localhost:8088/swagger-ui.html
```
