package com.abhay.app.controller;


import com.abhay.app.model.Appointment;
import com.abhay.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    AppointmentRepository appointmentRepository;
    @RequestMapping(value = "/myappointment",method = RequestMethod.GET)
    public Appointment getMyAppointments(@RequestParam("patientName") String patientName)
    {
        return appointmentRepository.findByPatientName(patientName);
    }

    @RequestMapping(value = "/Save",method = RequestMethod.POST)
    public Appointment saveAppointment(@RequestBody Appointment appointment)
    {
        appointment = appointmentRepository.save(appointment);
        return appointment;
    }
}
