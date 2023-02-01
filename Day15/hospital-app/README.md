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
curl --location --request POST 'localhost:8083/patient/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "patId":"03",
    "name":"pratik",
    "age":"30",
    "gender":"male",
    "disease":"smoking"
}'
```

### Get

```
curl --location --request GET 'localhost:8083/patient/read' \
--header 'Cookie: JSESSIONID=95D7CD6755A56ADA2704DC772E7A245F'
```

### put

```
curl --location --request PUT 'localhost:8083/patient/update?patid=05&name=nupur' \
--header 'Cookie: JSESSIONID=95D7CD6755A56ADA2704DC772E7A245F'
```

### delete

```
curl --location --request DELETE 'localhost:8083/patient/delete?name=pratik'
```

### findById

```
curl --location --request GET 'localhost:8083/patient/findByid?patid=04' \
--header 'Cookie: JSESSIONID=95D7CD6755A56ADA2704DC772E7A245F'
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

