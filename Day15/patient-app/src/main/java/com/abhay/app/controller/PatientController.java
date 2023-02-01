package com.abhay.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;


    @RequestMapping(value="/create",method = RequestMethod.POST)
    public Patient create(@RequestBody Patient patient)  {
        patient = patientRepository.save(patient);
        return patient;
    }

   @RequestMapping(value = "/read",method = RequestMethod.GET)
    public List<Patient> readPatient(){
        return patientRepository.findAll();
   }

   @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public void modifyPatient(@RequestParam String patid, @RequestParam String name){
       Patient patient = patientRepository.findByName(name);
       patient.setPatId(patid);
       patientRepository.save(patient);
   }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteByID(@RequestParam String name) {
        patientRepository.deleteByname(name);
    }

    @RequestMapping(value = "/findByid", method = RequestMethod.GET)
    public void findByID(@RequestParam String patid) {
        patientRepository.findBypatId(patid);
    }
}
