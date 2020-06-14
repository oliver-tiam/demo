# demo
A simple CRUD with role base functionality using Spring Boot, Spring Security, Hibernate and MySQL

1. For the database connection, kindly refer to the application.properties, and replace the username and password with apprpriate credentials.
spring.datasource.url=jdbc:mysql://localhost:3306/exam?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password

2. This is a Spring Boot application with an embedded Tomcat server, which will run the application at http://localhost:8080/ .
To run the jar, go to target directory and simply execute java -jar exam=0.0.1=SNAPSHOT.jar. Or if you are in the project root, simply run mvn spring-boot:run. Make maven is installed.

3. For the migration scripts, there are two sql files, namely, schema.sql and data.sql. THe schema.sql file contains the DDL structures of the tables, while data.sql contains the DML or the INSERT statements to pre populate the tables with values. These two files are located under resources folder and will run automatically when the project is run.

4. Default user accounts:
    a. admin – username and password for the default admin user account 
    b.  user – username and password for the default standard user account
    Both of these credentials are defined ithe users, roles and users_roles tables. The credential "admin" and "user" are both encrypted using BCryptPasswordEncoder.
    
    
***NOTES
TODOS: 
Due to time constraint

1. Contact Info and Address Info - My idea is to create two more tables as indicated below:

For Contact Infos:
   CREATE TABLE `contact_info` (
  `contact_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45),
  `flag` boolean  --- flag indicator for primary contact to appear in the list of employees
  PRIMARY KEY (`contact_info_id`)
   FOREIGN KEY (emp_id)
   REFERENCES employees(emp_id)
);

For Address Info
 CREATE TABLE `address_info` (
  `address_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(100),
  `address2` varchar(100),
  `city` varchar(100),
  `state` varchar(100),
  `zip` varchar(5),
  `country` varchar(100) NOT NULL,
  `flag` boolean  --- flag indicator for primary address to appear in the list of employees
  PRIMARY KEY (`address_info_id`)
   FOREIGN KEY (emp_id)
   REFERENCES employees(emp_id)
);

2. Paging functionality
3. Search functionality
4. REST endpoints
5. Integrate with Angular for client rich Front End functionality.
6. Validation for both client side and server side
7. JUnit tests

