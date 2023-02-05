package com.abhay.com.controller;

import com.abhay.com.model.Hospital;
import com.abhay.com.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class HospitalController {

    @Autowired
    RabbitMQSender rabbitMQSender;



    @GetMapping(value = "/hospital/producer")
    public String hospitalProducer( @RequestParam("hosId") String hosId,@RequestParam("name") String name,@RequestParam("city") String city) {

        Hospital hos=new Hospital();
        hos.setHosId(hosId);
        hos.setName(name);
        hos.setCity(city);
        rabbitMQSender.sendHospital(hos);

        return "Message sent to the RabbitMQ  Successfully";
    }
    @PostMapping(value = "/hospital")
    public String postHospital(@RequestBody Hospital hospital) {

        rabbitMQSender.sendHospital(hospital);

        return "Message sent to the RabbitMQ  Successfully";
    }
}
