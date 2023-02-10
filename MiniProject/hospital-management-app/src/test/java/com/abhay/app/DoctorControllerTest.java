package com.abhay.app;

import com.abhay.app.controller.DoctorController;
import com.abhay.app.model.Appointment;
import com.abhay.app.model.Prescription;
import com.abhay.app.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {

    @InjectMocks
    DoctorController doctorController;

    @Mock
    AppointmentRepository appointmentRepository;

    @Mock
    Appointment appointment;

    @BeforeEach
    void setUp(){
        appointmentRepository = Mockito.mock(AppointmentRepository.class);
        appointment = Mockito.mock(Appointment.class);
    }

    @Test
    public void getAppointmentsTest(){
        List<Appointment> appointments = new ArrayList();
        Prescription prescription1 = new Prescription("01pres","01","this medicin is for headache","yash","Dr.bala");
        Appointment appointment1 = new Appointment("110","yash","Dr.bala","4th march",prescription1);
        appointments.add(appointment1);
        when(appointmentRepository.findBydoctorName(anyString())).thenReturn(appointments);
        List<Appointment> result = doctorController.getAppointments("Dr.mehta");

        assertEquals(appointments.size(),1);
        assertEquals(appointments.get(0).getAppointmentId(),result.get(0).getAppointmentId());
        assertEquals(appointments.get(0).getPatientName(),result.get(0).getPatientName());
        assertEquals(appointments.get(0).getDoctorName(),result.get(0).getDoctorName());
        assertEquals(appointments.get(0).getDate(),result.get(0).getDate());
        assertEquals(appointments.get(0).getPrescription().getPrescriptionId(),result.get(0).getPrescription().getPrescriptionId());
        assertEquals(appointments.get(0).getPrescription().getAppointmentId(),result.get(0).getPrescription().getAppointmentId());
        assertEquals(appointments.get(0).getPrescription().getDescription(),result.get(0).getPrescription().getDescription());
        assertEquals(appointments.get(0).getPrescription().getDoctorName(),result.get(0).getPrescription().getDoctorName());


    }

    @Test
    public void saveAppointmentTest(){

        Prescription prescription = new Prescription("01pres","01","this medicin is for headache","yash","Dr.bala");

        Appointment appointments = new Appointment("110","yash","Dr.bala","4th march",prescription);


        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointments);

        Appointment result = doctorController.saveAppointment(appointment);


        assertEquals(appointments.getAppointmentId(),result.getAppointmentId());
        assertEquals(appointments.getDoctorName(),result.getDoctorName());
        assertEquals(appointments.getDate(),result.getDate());
        assertEquals(appointments.getPatientName(),result.getPatientName());
        assertEquals(appointments.getPrescription().getPrescriptionId(),result.getPrescription().getPrescriptionId());
        assertEquals(appointments.getPrescription().getAppointmentId(),result.getPrescription().getAppointmentId());
        assertEquals(appointments.getPrescription().getDescription(),result.getPrescription().getDescription());
        assertEquals(appointments.getPrescription().getPatientName(),result.getPrescription().getPatientName());
        assertEquals(appointments.getPrescription().getDoctorName(),result.getPrescription().getDoctorName());
    }
}
