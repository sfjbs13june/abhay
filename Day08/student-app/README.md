## Build application

``` 
mvn clean install
```

## Run application

``` 
mvn spring-boot:run
```

## Test Application

```  
Get List =  curl --location --request GET 'localhost:8080/get/students' \

Get Map =  curl --location --request GET 'localhost:8080/map/students' \
```

### Dockerization

```
$ mvn install dockerfile:build
```
### List docker images
```
$ docker images
```

### Running the application in docker container

```
$ docker run -p 8080:8080 abhaysingh19/student-app:0.0.1-SNAPSHOT 
```

### List docker running container

```
$ docker ps
```