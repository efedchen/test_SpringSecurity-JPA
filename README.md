Simplest Spring Boot + Spring Security sample application
============================

The application uses Spring Boot with Spring Security for login form creation and JPA+MySQL for DAO-based authentication


## Technologies
* Java 8+
* Spring Boot 2.3.5
* Spring Data JPA for persistence
* Maven 3.0+
* MySQL

## Configuration

### Dependencies
##### Spring boot, Spring Security, JPA
```xml
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```
##### MySQL Connector
```xml
    <dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <scope>runtime</scope>
    </dependency>
```
### MySQL configuration
Configurations are stored in `application.properties` file.  
You need to specify username, password, URL to your database and db schema:  
```
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
```
Also you need to create table ``user`` in accordance with ``User`` class.
For example:

![User table configuration](https://github.com/efedchen/test_SpringSecurity-JPA/blob/media/src/main/resources/static/img/dbTableConf.png?raw=true "User table configuration")
