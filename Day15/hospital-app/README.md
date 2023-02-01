### Create the Calculator-app

https://start.spring.io/

### Build the application

```
mvn clean install
```


### Run the application

``` 
docker-compose -f docker-compose-mongo.yml up -d
mvn spring-boot:run
docker-compose -f docker-compose-mongo.yml down

```

### Post 
```
curl --location --request POST 'localhost:8083/hospital/create' \
--header 'Authorization: Basic YWJoYXkxMjM6cGFzc3dvcmQ=' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=141A0949BE61D229F56DEEBE9DB9DD8A' \
--data-raw '{
    "hosId":"02",
    "name":"diwan",
    "city":"mumbai"
}'
```

### Get

```
curl --location --request GET 'localhost:8083/hospital/read' \
--header 'Cookie: JSESSIONID=79A80C6E9198D1BD236DE149FD1B35AD'
```

### put

```
curl --location --request PUT 'localhost:8083/hospital/update?hosId=4&name=diwan' \
--header 'Authorization: Basic cmFodWwxMjM6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=79A80C6E9198D1BD236DE149FD1B35AD'
```

### delete

```
curl --location --request PUT 'localhost:8083/hospital/update?hosId=4&name=diwan' \
--header 'Authorization: Basic cmFodWwxMjM6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=79A80C6E9198D1BD236DE149FD1B35AD'
```

### findById

```
curl --location --request GET 'localhost:8083/hospital/findByid?hosId=02' \
--header 'Cookie: JSESSIONID=79A80C6E9198D1BD236DE149FD1B35AD'
```


### Security for application

```
Post = curl --location --request POST 'localhost:8083/hospital/create' \
--header 'Authorization: Basic YWJoYXkxMjM6cGFzc3dvcmQ=' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=141A0949BE61D229F56DEEBE9DB9DD8A' \
--data-raw '{
    "hosId":"02",
    "name":"diwan",
    "city":"mumbai"
}'

Put = curl --location --request PUT 'localhost:8083/hospital/update?hosId=4&name=diwan' \
--header 'Authorization: Basic cmFodWwxMjM6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=79A80C6E9198D1BD236DE149FD1B35AD'

```

## Show data

```
docker exec -it hospital-app-mongo-1 bash

mongo

show dbs

show tables

db.customer.find()

```


### Dockerization

### Maven
Here i am using maven spotify plugin to create the docker image for this application.
Use the below command to create the docker image.
For creating please use your repository to create the image which will be easy to push image in your docker hub.
update in your pom.xml.
<docker.image.prefix> <your repo name> </docker.image.prefix>

```bash
$ mvn install dockerfile:build
```

### Push docker images

```bash
docker login

$ docker push <repository-name>/<app-name>

```

