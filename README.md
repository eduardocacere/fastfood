# Fast Food

The fast-food restaurant management system aims to:

- **Manage customers:** register, view, edit and delete customers.
- **Manage products:** register, view, edit and delete products.
- **Manage orders:** register, view, edit and delete orders.
- **Generate checkout for payment:** with order information for the customer to complete payment.

### Process flow of how fast food should work
![img.png](img.png)



# Getting Started

### Technologies used

**Project developed in Kotlin**

- JDK 17
- Kotlin 1.9
- Maven 3.9.5
- Spring Boot 3.2.1
- Data Base MongoDB 7


### Reference Documentation
Some of the technologies used in the project:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.nosql.mongodb)
* [Validation](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#io.validation)

## Run the project

#### Build of project
``mvn package``

#### Generate imagem docker
`` docker build -t fastfood:lasted . ``

#### Start project services and dependencies
When running the docker composer file, the mongodb database is started,
already including some masses of data in the base for product and customer collections

``docker-compose -f docker-compose.yml up``


