package com.abhay.app.controller;

import com.abhay.app.model.Prescription;
import com.abhay.app.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @RequestMapping(value = "/viewprescription",method = RequestMethod.GET)
    public List<Prescription> getAllPrescription(@RequestParam("patientName") String patientName){
        return prescriptionRepository.findByPatientName(patientName);
    }
    @RequestMapping(value = "/saveprescription",method = RequestMethod.POST)
    public Prescription savePrescription(@RequestBody Prescription prescription){
        prescription = prescriptionRepository.save(prescription);
        return prescription;
    }
}
