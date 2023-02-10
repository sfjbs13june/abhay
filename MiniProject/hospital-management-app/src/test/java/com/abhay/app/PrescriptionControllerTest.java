package com.abhay.app;

import com.abhay.app.controller.PrescriptionController;
import com.abhay.app.model.Prescription;
import com.abhay.app.repository.PrescriptionRepository;
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
public class PrescriptionControllerTest {

    @InjectMocks
    PrescriptionController prescriptionController;

    @Mock
    PrescriptionRepository prescriptionRepository;

    @Mock
    Prescription prescription;

    @BeforeEach
    void setUp(){
        prescription = Mockito.mock(Prescription.class);
        prescriptionRepository = Mockito.mock(PrescriptionRepository.class);
    }

    @Test
    public void getAllPrescriptionTest(){
        List<Prescription> prescriptions = new ArrayList();
        Prescription prescription1 = new Prescription("01pres","01","this medicin is for headache","yash","Dr.bala");
        prescriptions.add(prescription1);
        when(prescriptionRepository.findByPatientName(anyString())).thenReturn(prescriptions);
        List<Prescription> result = prescriptionController.getAllPrescription("yash");

        assertEquals(prescriptions.size(),1);
        assertEquals(prescriptions.get(0).getPrescriptionId(),result.get(0).getPrescriptionId());
        assertEquals(prescriptions.get(0).getAppointmentId(),result.get(0).getAppointmentId());
        assertEquals(prescriptions.get(0).getDescription(),result.get(0).getDescription());
        assertEquals(prescriptions.get(0).getPatientName(),result.get(0).getPatientName());
        assertEquals(prescriptions.get(0).getDoctorName(),result.get(0).getDoctorName());


    }

    @Test
    public void savePrescriptionTest(){
        Prescription prescription1 = new Prescription("01pres","01","this medicin is for headache","yash","Dr.bala");
        when(prescriptionRepository.save(any(Prescription.class))).thenReturn(prescription1);
        Prescription result = prescriptionController.savePrescription(prescription);


        assertEquals(prescription1.getPrescriptionId(),result.getPrescriptionId());
        assertEquals(prescription1.getAppointmentId(),result.getAppointmentId());
        assertEquals(prescription1.getPatientName(),result.getPatientName());
        assertEquals(prescription1.getDoctorName(),result.getDoctorName());
        assertEquals(prescription1.getDescription(),result.getDescription());
    }
}
