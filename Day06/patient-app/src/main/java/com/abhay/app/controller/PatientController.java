package com.abhay.app.controller;


import com.abhay.app.model.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @PostMapping("/patient/save")
    public Patient savePatient(@RequestBody Patient patient){
        System.out.println(patient);
        return patient;
    }
}
