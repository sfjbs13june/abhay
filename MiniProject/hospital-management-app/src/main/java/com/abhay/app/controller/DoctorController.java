package com.abhay.app.controller;

import com.abhay.app.model.Appointment;
import com.abhay.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    AppointmentRepository appointmentRepository;
    @RequestMapping(value = "/appointment",method = RequestMethod.GET)
    public List<Appointment> getAppointments(@RequestParam("doctorName") String doctorName)
    {
        return appointmentRepository.findBydoctorName(doctorName);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Appointment saveAppointment(@RequestBody Appointment appointment)
    {
        appointment = appointmentRepository.save(appointment);
        return appointment;
    }
}
