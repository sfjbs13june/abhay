package com.abhay.app.service;


import com.abhay.app.controller.Patient;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class PatientService {

    public Patient updateDetail(@NotNull Patient patient, String disease, String age){
     patient.setDisease(disease);
     patient.setAge(age);
     return patient;
    }

}
