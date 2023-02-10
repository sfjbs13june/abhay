package com.abhay.app;

import com.abhay.app.controller.PatientController;
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
public class PatientControllerTest {

    @InjectMocks
    PatientController patientController;

    @Mock
    AppointmentRepository appointmentRepository;

    @Mock
    Appointment appointment;

    @BeforeEach
    void setUp(){
        appointmentRepository = Mockito.mock(AppointmentRepository.class);

    }

    @Test
    public void getMyAppointmentTest(){
        List<Appointment> appointments = new ArrayList();
        Prescription prescription1 = new Prescription("01pres","01","this medicin is for headache","yash","Dr.bala");
        Appointment appointment1 = new Appointment("110","yash","Dr.bala","4th march",prescription1);
        appointments.add(appointment1);
        when(appointmentRepository.findByPatientName(anyString())).thenReturn(appointments);
        List<Appointment> result = patientController.getMyAppointment("yash");

        assertEquals(appointments.size(),1);
        assertEquals(appointments.get(0).getAppointmentId(),result.get(0).getAppointmentId());
        assertEquals(appointments.get(0).getPatientName(),result.get(0).getPatientName());
        assertEquals(appointments.get(0).getDoctorName(),result.get(0).getDoctorName());
        assertEquals(appointments.get(0).getDate(),result.get(0).getDate());
        assertEquals(appointments.get(0).getPrescription().getPrescriptionId(),result.get(0).getPrescription().getPrescriptionId());
        assertEquals(appointments.get(0).getPrescription().getAppointmentId(),result.get(0).getPrescription().getAppointmentId());
        assertEquals(appointments.get(0).getPrescription().getDescription(),result.get(0).getPrescription().getDescription());
        assertEquals(appointments.get(0).getPrescription().getDoctorName(),result.get(0).getPrescription().getDoctorName());
        assertEquals(appointments.get(0).getPrescription().getPatientName(),result.get(0).getPrescription().getPatientName());
    }

    @Test
    public void saveAppointmentTest()
    {

       Prescription prescription1 = new Prescription("01pres","01","this medicin is for headache","yash","Dr.bala");
       Appointment appointment1 = new Appointment("110","yash","Dr.bala","4th march",prescription1);


       when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment1);
       Appointment result = patientController.saveAppointment(appointment);



        assertEquals(appointment1.getAppointmentId(),result.getAppointmentId());
        assertEquals(appointment1.getDoctorName(),result.getDoctorName());
        assertEquals(appointment1.getDate(),result.getDate());
        assertEquals(appointment1.getPatientName(),result.getPatientName());
        assertEquals(appointment1.getPrescription().getPrescriptionId(),result.getPrescription().getPrescriptionId());
        assertEquals(appointment1.getPrescription().getAppointmentId(),result.getPrescription().getAppointmentId());
        assertEquals(appointment1.getPrescription().getDescription(),result.getPrescription().getDescription());
        assertEquals(appointment1.getPrescription().getPatientName(),result.getPrescription().getPatientName());
        assertEquals(appointment1.getPrescription().getDoctorName(),result.getPrescription().getDoctorName());



    }

}
