### Created calculator-springboot-app and
added spring.web tomcat server for the container
https://start.spring.io/

### To build application
mvn clean install

### To run application
mvn spring-boot:run

### To test the application
add == curl  GET 'localhost:8081/add?a=10.0&b=3.0'
sub == curl --location --request GET 'localhost:8081/sub?a=10.0&b=3.0'
mul == curl --location --request GET 'localhost:8081/mul?a=10.0&b=3.0'
div == curl --location --request GET 'localhost:8081/div?a=10.0&b=3.0'


### code in application.properties
server.port = 8080
spring.profiles.active = dev
### added application-dev.properties file
it is used to add environment 
server.port =8081
spring.profiles.active = prod
### added application-prod.properties file
server.port = 8082
