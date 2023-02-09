package com.abhay.app;

import com.abhay.app.controller.DoctorController;
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
        List list = new ArrayList();
        when(appointmentRepository.findBydoctorName(anyString())).thenReturn(list);
        List result = doctorController.getAppointments("Dr.mehta");
        assertEquals(list,result);
    }

    @Test
    public void saveAppointmentTest(){
        Appointment appointment1 = new Appointment();
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment1);

        Appointment result = doctorController.saveAppointment(appointment);

        assertEquals(appointment1,result);
    }
}
