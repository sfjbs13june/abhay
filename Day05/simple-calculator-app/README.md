[```` Create the Calculator-app ````]()

https://start.spring.io/

````Build the application ````[]()

mvn clean install

[````Run the application````]()

mvn spring-boot:run

[````Testing the application````]()

Addition == curl --location --request GET 'localhost:8080/add?a=10&b=20'

Subtraction == curl --location --request POST 'localhost:8080/sub?a=12&b=2'

Multiplication == curl --location --request PUT 'localhost:8080/mul?a=13&b=1'

Division == curl --location --request DELETE 'localhost:8080/div?a=10&b=4'