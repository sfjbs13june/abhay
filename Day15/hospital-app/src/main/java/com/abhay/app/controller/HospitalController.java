package com.abhay.app.controller;



import com.abhay.app.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;


    @RequestMapping(value="/create",method = RequestMethod.POST)
    public Hospital create(@RequestBody Hospital hospital)  {
        hospital = hospitalRepository.save(hospital);
        return hospital;
    }

   @RequestMapping(value = "/read",method = RequestMethod.GET)
    public List<Hospital> readHospital(){
        return hospitalRepository.findAll();
   }

   @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public void modifyHospital(@RequestParam String hosId, @RequestParam String name){

       Hospital hospital= hospitalRepository.findByName(name);
       hospital.setHosId(hosId);
       hospitalRepository.save(hospital);
   }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteByID(@RequestParam String name) {
        hospitalRepository.deleteByName(name);
    }

    @RequestMapping(value = "/findByid", method = RequestMethod.GET)
    public void findByID(@RequestParam String hosId) {
        hospitalRepository.findByHosId(hosId);
    }
}
