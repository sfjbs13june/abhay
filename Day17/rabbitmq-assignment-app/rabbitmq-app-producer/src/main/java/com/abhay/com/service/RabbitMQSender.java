package com.abhay.com.service;

import com.abhay.com.model.Hospital;
import com.abhay.com.model.Patient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routingkey.name}")
    private String routingkey;

    public void sendHospital(Hospital hospital) {
        rabbitTemplate.convertAndSend(exchange, routingkey, hospital);
        System.out.println("Send msg = " + hospital);
    }

    public void sendPatient(Patient patient) {
        rabbitTemplate.convertAndSend(exchange, routingkey, patient);
        System.out.println("Send msg = " + patient);
    }
}
