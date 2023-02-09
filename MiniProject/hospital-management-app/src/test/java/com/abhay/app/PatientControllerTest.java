package com.abhay.app;

import com.abhay.app.controller.PatientController;
import com.abhay.app.model.Appointment;
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
        List list = new ArrayList();
        when(appointmentRepository.findByPatientName(anyString())).thenReturn(list);
        List result = patientController.getMyAppointment("raj");

        assertEquals(list,result);
    }

    @Test
    public void saveAppointmentTest()
    {
       Appointment appointment1 = new Appointment();
       when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment1);
       Appointment result = patientController.saveAppointment(appointment);

       assertEquals(appointment1,result);
    }

}
