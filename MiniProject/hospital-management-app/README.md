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
--header 'Content-Type: application/json' \
--data-raw '{
"appointmentId" : "105",
"patientName":"Ram",
"doctorName":"Dr.rakesh",
"date":"12th march",
"prescription":
{
"prescriptionId":"pres13",
"appointmentId":"102",
"description":"He had fever",
"patientName":"Ram",
"doctorName":"Dr.rakesh"
}
}'

```

### GET 

```
curl --location --request GET 'localhost:8080/doctor/appointment?doctorName=Dr.rakesh' \
--header 'Authorization: Basic ZG9jdG9yMTIzOnBhc3N3b3Jk' \
--header 'Cookie: JSESSIONID=AB8EFBD74E5DEDFD1DCFB63563B24CFA'

```
### PatientController

### POST

```
curl --location --request POST 'localhost:8080/patient/save' \
--header 'Authorization: Basic cGF0aWVudDEyMzpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=AB8EFBD74E5DEDFD1DCFB63563B24CFA' \
--data-raw '{
    "appointmentId": "104",
    "patientName": "ayush",
    "doctorName": "Dr.pratik",
    "date": "10feb 2023",
   "prescription": 
        {
            "prescriptionId": "10pres",
            "appointmentId": "104",
            "description": "cold and cough",
            "patientName": "ayush",
            "doctorName": "Dr.pratik"
        }
    
}'
```

### GET

```
curl --location --request GET 'localhost:8080/patient/myappointment?patientName=abhay'

```

### PrescriptionController

### POST

```
curl --location --request POST 'localhost:8080/prescription/saveprescription' \
--header 'Content-Type: application/json' \
--data-raw '{
    "prescriptionId": "03pres",
    "appointmentId": "102",
    "description": "headache disease",
    "patientName": "abhay",
    "doctorName": "MR.Vinayak"
}'
```

### GET

```
curl --location --request GET 'localhost:8080/prescription/viewprescription?patientName=abhay'
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

