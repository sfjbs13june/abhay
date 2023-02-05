package com.abhay.rabbitmq.service;

import com.abhay.rabbitmq.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.test.context.ActiveProfiles;
import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = "test")
public class RabbitMQSenderTest {

  @InjectMocks
  com.abhay.rabbitmq.service.RabbitMQSender rabbitMQSender;

  @Mock
  AmqpTemplate amqpTemplate;

@Test
  public void sendTest() {
    Employee employee=new Employee();
   // doNothing().when(amqpTemplate).convertAndSend(anyString(),anyString(),any(Employee.class));
    rabbitMQSender.send(employee);
   //verify(amqpTemplate, times(1)).convertAndSend("exchange","queue",employee);
  }


}
