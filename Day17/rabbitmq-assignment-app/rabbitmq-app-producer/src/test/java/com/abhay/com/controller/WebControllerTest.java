package com.abhay.com.controller;

import com.abhay.com.model.Hospital;

import com.abhay.com.model.Patient;
import com.abhay.com.service.RabbitMQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.test.context.ActiveProfiles;


import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = "test")
public class WebControllerTest {
  @InjectMocks
  WebControllerTest webControllerTest;


  @Mock
  RabbitMQSender rabbitMQSender;

  @Test
  public void producerTest() {

    doNothing().when(rabbitMQSender).sendHospital(any(Hospital.class));
    doNothing().when(rabbitMQSender).sendPatient(any(Patient.class));

    //String result = webControllerTest.producer("hosId1", "name1", "city1");
  }


}