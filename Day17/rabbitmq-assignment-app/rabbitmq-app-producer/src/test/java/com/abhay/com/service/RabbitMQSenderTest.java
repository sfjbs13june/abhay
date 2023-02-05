package com.abhay.com.service;

import com.abhay.com.model.Hospital;
import com.abhay.com.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.test.context.ActiveProfiles;


@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = "test")
public class RabbitMQSenderTest {

  @InjectMocks
  RabbitMQSender rabbitMQSender;

  @Mock
  AmqpTemplate amqpTemplate;

@Test
  public void sendHospitalTest() {
    Hospital hos=new Hospital();
   // doNothing().when(amqpTemplate).convertAndSend(anyString(),anyString(),any(Employee.class));
    rabbitMQSender.sendHospital(hos);
//verify(amqpTemplate, times(1)).convertAndSend("exchange","queue",employee);
  }

  @Test
  public void sendPatientTest() {
    Patient pat=new Patient();
    // doNothing().when(amqpTemplate).convertAndSend(anyString(),anyString(),any(Employee.class));
    rabbitMQSender.sendPatient(pat);
//verify(amqpTemplate, times(1)).convertAndSend("exchange","queue",employee);
  }


}
