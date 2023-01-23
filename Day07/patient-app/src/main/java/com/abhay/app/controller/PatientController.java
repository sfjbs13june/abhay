package com.abhay.app.controller;


import com.abhay.app.exception.*;
import com.abhay.app.model.Patient;
import com.abhay.app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/patient/save")
    public Patient savePatient(@RequestBody Patient patient) throws PatientIdNotFoundException, PatientNameNotFoundException, PatientAgeNotFoundException , PatientGenderNotFoundException,PatientDiseaseNotFoundException {
        if(patient.getId() == null){
               throw new PatientIdNotFoundException("Patient id is not found");
        }
        if(patient.getName() == null){
            throw new PatientNameNotFoundException("Patient name is not found");
        }
        if(patient.getAge() == null){
            throw new PatientAgeNotFoundException("Patient age is not found");
        }
        if(patient.getGender() == null){
            throw new PatientGenderNotFoundException("Patient gender is not found");
        }
        if(patient.getDisease() == null){
            throw new PatientDiseaseNotFoundException("Patient disease is not found");
        }
        System.out.println(patient);
        return patient;
    }

    @PutMapping("/patient/update")
    public Patient updateDetail(@RequestBody Patient patient, @RequestParam("disease") String disease,@RequestParam("age") String age){
        return patientService.updateDetail(patient,disease,age);

    }

}
