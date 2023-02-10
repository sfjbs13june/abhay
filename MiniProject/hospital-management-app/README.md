### spring boot application

```
https://start.spring.io/
```

### Run the application

```
mvn clean install
```

### Build the application
```
mvn spring-boot:run
```

### Dockerization

```
mvn install dockerfile:build
```

### Docker compose

```
docker-compose -f docker-compose-mongo.yml up -d
docker-compose -f docker-compose-mongo.yml down
```

### DoctorController

### POST

```
curl --location --request POST 'localhost:8080/doctor/save' \
--header 'Authorization: Basic ZG9jdG9yMTIzOnBhc3N3b3Jk' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=8E0722A54E25ECA20D2ACBA1EADC1951' \
--data-raw '{
"appointmentId" : "111",
"patientName":"Ram",
"doctorName":"Dr.pratik",
"date":"12th march",
"prescription":
{
"prescriptionId":"pres13",
"appointmentId":"102",
"description":"He had fever",
"patientName":"Ram",
"doctorName":"Dr.pratik"
}
}'

```

### GET 

```
curl --location --request GET 'localhost:8080/doctor/appointment?doctorName=Dr.pratik' \
--header 'Authorization: Basic ZG9jdG9yMTIzOnBhc3N3b3Jk' \
--header 'Cookie: JSESSIONID=8E0722A54E25ECA20D2ACBA1EADC1951'

```
### PatientController

### POST

```
curl --location --request POST 'localhost:8080/patient/save' \
--header 'Authorization: Basic cGF0aWVudDEyMzpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=8E0722A54E25ECA20D2ACBA1EADC1951' \
--data-raw '{
    "appointmentId": "106",
    "patientName": "mukul",
    "doctorName": "Dr.pratik",
    "date": "10feb 2023",
   "prescription": 
        {
            "prescriptionId": "10pres",
            "appointmentId": "10",
            "description": "pain",
            "patientName": "mukul",
            "doctorName": "Dr.pratik"
        }
    
}'

```

### GET

```
curl --location --request GET 'localhost:8080/patient/myappointment?patientName=mukul' \
--header 'Authorization: Basic cGF0aWVudDEyMzpwYXNzd29yZA==' \
--header 'Cookie: JSESSIONID=8E0722A54E25ECA20D2ACBA1EADC1951'

```

### PrescriptionController

### POST

```
curl --location --request POST 'localhost:8080/prescription/saveprescription' \
--header 'Authorization: Basic ZG9jdG9yMTIzOnBhc3N3b3Jk' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=8E0722A54E25ECA20D2ACBA1EADC1951' \
--data-raw '{
    "prescriptionId": "08pres",
    "appointmentId": "110",
    "description": "eye problem",
    "patientName": "abhay",
    "doctorName": "Dr.pratik"
}'
```

### GET

```
curl --location --request GET 'localhost:8080/prescription/viewprescription?patientName=abhay' \
--header 'Cookie: JSESSIONID=8E0722A54E25ECA20D2ACBA1EADC1951'
```

### Security

```
.antMatchers(HttpMethod.GET, "/doctor/appointment").hasAnyRole("DOCTOR")
.antMatchers(HttpMethod.GET, "/patient/myappointment").hasAnyRole("PATIENT")
.antMatchers(HttpMethod.POST,"/doctor/save").hasAnyRole("DOCTOR")
.antMatchers(HttpMethod.POST,"/patient/save").hasAnyRole("PATIENT")
.antMatchers(HttpMethod.GET,"/prescription/saveprescription").hasAnyRole("PATIENT","DOCTOR")
.antMatchers(HttpMethod.POST,"/prescription/viewprescription").hasAnyRole("PATIENT","DOCTOR")
                
```

### Show Database

```
docker exec -it hospital-management-app-mongo-1 bash

mongo

show dbs

show tables

db.appointment.find()

db.prescription.find()

```

### Swegger Page

```
http://localhost:8080/swagger-ui/index.html

```

