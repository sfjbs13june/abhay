### Create the Calculator-app

https://start.spring.io/

### Build the application

```
mvn clean install
```


### Run the application

```
mvn spring-boot:run
```


### Testing the application

```
Put = curl --location --request PUT 'localhost:8081/patient/update?disease=cough&age=22' 

Post = curl --location --request POST 'localhost:8081/patient/save' 
```

### Security for application

```
Put = curl --location --request PUT 'localhost:8081/patient/update?disease=cough&age=22' \
--header 'Authorization: Basic cmFodWwxMjM6cGFzc3dvcmQ=' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=737554989FD154A178D2144BC56492FC' \
--data-raw '{
     "id" : "123",
     "name" : "pat123",
     "age" : "3",
    "gender" : "male",
    "disease" : "bactrial"
}' 

Post = curl --location --request POST 'localhost:8081/patient/save' \
--header 'Authorization: Basic YWJoYXkxMjM6cGFzc3dvcmQ=' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=737554989FD154A178D2144BC56492FC' \
--data-raw '{
     "id" : "123",
     "name" : "pat123",
     "age" : "3",
    "gender" : "male",
    "disease" : "bactrial"
}' 

```